function karateConfigProd() {
    var config = {
        
        environment: 'prod',
        urlBase: karate.properties['urlBase'] || 'https://jsonplaceholder.typicode.com',
        
        endpoints: {
            posts: '/posts',
            users: '/users',
            comments: '/posts/1/comments'
        },
        
        performance: {
            rampUsers: parseInt(karate.properties['rampUsers'] || '1'),
            during: parseInt(karate.properties['during'] || '5'),
            thresholds: {
                responseTimeMax: parseInt(karate.properties['responseTimeMax'] || '2000'),
                errorRateMax: parseFloat(karate.properties['errorRateMax'] || '10.0'),
                requestsPerSecMin: parseFloat(karate.properties['requestsPerSecMin'] || '1.0'),
                successfulRequestsMin: parseInt(karate.properties['successfulRequestsMin'] || '20')
            }
        },

        timeouts: {
            default: 20000,
            connection: 3000,
            read: 10000
        },

        defaultHeaders: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
            'User-Agent': 'Karate-Performance-Test/1.0',
            'X-Environment': 'prod'
        },
        
        logging: {
            level: 'WARN',
            prettyPrint: false
        }
    };

    karate.configure('connectTimeout', config.timeouts.connection);
    karate.configure('readTimeout', config.timeouts.read);
    karate.configure('logPrettyRequest', config.logging.prettyPrint);
    karate.configure('logPrettyResponse', config.logging.prettyPrint);
    
    return config;
}