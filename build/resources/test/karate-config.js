function fn() {

    var env = karate.env || 'prod';
    karate.log('Karate environment:', env);
    
    var config;
    try {
        if (env === 'qa') {
            config = karate.callSingle('classpath:config/karate-config-qa.js');
        } else if (env === 'prod') {
            config = karate.callSingle('classpath:config/karate-config-prod.js');
        } else {
            config = karate.callSingle('classpath:config/karate-config-dev.js');
        }
    } catch (e) {
        karate.log('Error loading environment config, using defaults:', e.message);
        
        config = {
            environment: 'dev',
            urlBase: 'https://jsonplaceholder.typicode.com',
            endpoints: {
                posts: '/posts',
                users: '/users',
                comments: '/posts/1/comments'
            },
            performance: {
                rampUsers: 5,
                during: 30,
                thresholds: {
                    responseTimeMax: 2000,
                    errorRateMax: 5.0,
                    requestsPerSecMin: 1.0,
                    successfulRequestsMin: 50
                }
            },
            timeouts: {
                default: 30000,
                connection: 5000,
                read: 15000
            },
            defaultHeaders: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        };
        
        
        karate.configure('connectTimeout', 5000);
        karate.configure('readTimeout', 15000);
    }
    
    karate.configure('ssl', true);
    karate.configure('charset', 'utf-8');
    
    karate.log('Configuration loaded for environment:', config.environment);
    karate.log('Base URL:', config.urlBase);
    
    config.urlBase = config.urlBase;
    config.endpoints = config.endpoints;
    config.performance = config.performance;
    
    return config;
}





