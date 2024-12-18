package co.com.bancolombia.certification.svn.application.entrypoint;

import co.com.bancolombia.certification.svn.application.exceptions.CustomException;
import co.com.bancolombia.certification.svn.application.strategy.SerenityFirebaseImplementation;
import co.com.bancolombia.certification.svn.factory.firestore.FireStoreConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static co.com.bancolombia.certification.svn.utils.LoggerMessage.*;
import static co.com.bancolombia.certification.svn.utils.SystemConstants.*;

public class DataManagement {

    private static final Logger logger = LoggerFactory.getLogger(DataManagement.class);
    private static final int MIN_COMMAND_PARTS = 4;
    private static final String REGEX_COMMAND = "##@[^@]*@";
    private static final String REGEX_VALUE = "\"([^\"]*)\"";



    private DataManagement(){

    }
    public static void overWriteFeature(String inputFeaturePath, String firebaseKeyPath) {
        Map<String,Object> commandInfo = new HashMap<>();
        Pattern pattern = Pattern.compile(REGEX_COMMAND);
        Pattern valuePattern = Pattern.compile(REGEX_VALUE);
        StringBuilder newContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFeaturePath))) {
            String line;
            boolean findFlag = false;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                Matcher valueMatcher = valuePattern.matcher(line);
                if(findFlag){
//                    line = line.replace("|","econtrado");
//                    if(valueMatcher.find()){
//                        line = valueMatcher.replaceAll("\"encontrado\"");
//                    }
                    findFlag = false;
                }
                if(matcher.find()){
                    findFlag = true;
                    commandInfo = getCommandComponents(line);
                    getDataOfDataBase(commandInfo,firebaseKeyPath);
                }
                newContent.append(line).append(System.lineSeparator());
            }
            Path featurePath = Paths.get(inputFeaturePath);
            Files.write(featurePath,newContent.toString().getBytes());
        } catch (IOException e) {
            throw new CustomException(SEARCHING_PATTERN_ERROR,e);
        }

    }

    private static Map<String,Object> getCommandComponents(String commandLine){
        Map<String,Object> commandComponents = new HashMap<>();
        String[] commandParts = commandLine.split("@");

        int commandLength = commandParts.length;
        if(commandLength >= MIN_COMMAND_PARTS){
            commandComponents.put(COLLECTION_NAME, commandParts[2]);
            commandComponents.put(DOCUMENT_NAME, commandParts[3]);
            if(commandLength>MIN_COMMAND_PARTS){
                List<String> values = Arrays.asList(Arrays.copyOfRange(
                        commandParts,MIN_COMMAND_PARTS,commandLength
                ));
                commandComponents.put(VALUE,values);
            }

            return commandComponents;
        }else{
            logger.error(COMMAND_LINE_ERROR);
            return Collections.emptyMap();
        }
    }


    private static String getDataOfDataBase(Map<String,Object> command, String keyPath){
        SerenityFirebaseImplementation sfi = new SerenityFirebaseImplementation(keyPath);
        String collectionName = command.get(COLLECTION_NAME).toString();
        //Invoke the serenityUseCase methods according to commandInfo contains
        if(command.containsKey(VALUE) && command.containsKey(DOCUMENT_NAME) ){
            //1. if value exist into commandInfo -> getSpecificDataValue
            System.out.println("NADA");
        }else if(command.containsKey(DOCUMENT_NAME)){
            String documentName = command.get(DOCUMENT_NAME).toString();
            //2. if value does not exist into commandInfo -> getSpecificData
            List<String> mappedInfo = sfi.getAllDataFromDocument(collectionName,documentName);
            System.out.println(mappedInfo);
        }else {
            //3. if document does not exist into commandInfo -> getAllData (not apply for this moment)
        }
        return null;
    }

    private static String processOutlineExampleValues(String line){
        return null;
    }
    private static String processOtherValues(String line){
        return null;
    }


}
