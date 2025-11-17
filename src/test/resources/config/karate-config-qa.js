function fn() {
    var config = {

        environment: 'qa',
        urlBase: karate.properties['urlBase'] || 'https://qa-api.example.com',
        
        endpoints: {
            posts: '/posts',
            users: '/users', 
            comments: '/posts/1/comments'
        },

        performance: {
            rampUsers: parseInt(karate.properties['rampUsers'] || '10'),
            during: parseInt(karate.properties['during'] || '60'),
            thresholds: {
                responseTimeMax: parseInt(karate.properties['responseTimeMax'] || '1500'),
                errorRateMax: parseFloat(karate.properties['errorRateMax'] || '3.0'),
                requestsPerSecMin: parseFloat(karate.properties['requestsPerSecMin'] || '5.0'),
                successfulRequestsMin: parseInt(karate.properties['successfulRequestsMin'] || '100')
            }
        },

        timeouts: {
            default: 25000,
            connection: 5000,
            read: 12000
        },

        defaultHeaders: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
            'User-Agent': 'Karate-Performance-Test/1.0',
            'X-Environment': 'qa'
        },

        logging: {
            level: 'INFO',
            prettyPrint: false
        }
    };

    karate.configure('connectTimeout', config.timeouts.connection);
    karate.configure('readTimeout', config.timeouts.read);
    karate.configure('logPrettyRequest', config.logging.prettyPrint);
    karate.configure('logPrettyResponse', config.logging.prettyPrint);
    
    return config;
}