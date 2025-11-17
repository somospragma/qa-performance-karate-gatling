function karateConfigDev() {
    var config = {

        environment: 'dev',
        urlBase: karate.properties['urlBase'] || 'https://jsonplaceholder.typicode.com',
        
        endpoints: {
            posts: '/posts',
            users: '/users',
            comments: '/posts/1/comments'
        },
        
        performance: {
            rampUsers: parseInt(karate.properties['rampUsers'] || '5'),
            during: parseInt(karate.properties['during'] || '30'),
            thresholds: {
                responseTimeMax: parseInt(karate.properties['responseTimeMax'] || '2000'),
                errorRateMax: parseFloat(karate.properties['errorRateMax'] || '5.0'),
                requestsPerSecMin: parseFloat(karate.properties['requestsPerSecMin'] || '1.0'),
                successfulRequestsMin: parseInt(karate.properties['successfulRequestsMin'] || '50')
            }
        },
        
        timeouts: {
            default: 30000,
            connection: 5000,
            read: 15000
        },

        defaultHeaders: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
            'User-Agent': 'Karate-Performance-Test/1.0'
        },

        logging: {
            level: 'DEBUG',
            prettyPrint: true
        }
    };
    
    karate.configure('connectTimeout', config.timeouts.connection);
    karate.configure('readTimeout', config.timeouts.read);
    karate.configure('logPrettyRequest', config.logging.prettyPrint);
    karate.configure('logPrettyResponse', config.logging.prettyPrint);
    
    return config;
}