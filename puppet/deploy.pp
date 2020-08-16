class dockerwar::deploy {

    file {'/home/beniwal/docker':
            ensure => directory,
            mode => '0777'
    }

    file {'/home/beniwal/docker/target':
            ensure => directory,
            mode => '0777'
    }

    file {'/home/beniwal/docker/target/calculator.war':
            mode => '0777',
            source => "puppet:///modules/dockerwar/calculator.war"
    }

    file {'/home/beniwal/docker/Dockerfile':
            mode => '0777',
            source => "puppet:///modules/dockerwar/Dockerfile"
    }
    exec {'Docker build':
            cwd => '/home/beniwal/docker/',
            command => '/usr/bin/docker build -t calculatorwithwar .'
    }

    exec {'Docker rm':
            cwd => '/home/beniwal/docker/',
            command => '/usr/bin/docker rm --force calculator8888 || echo'
    }

    exec {'Docker run':
            cwd => '/home/beniwal/docker/',
            command => '/usr/bin/docker run -d -p 8888:8080 --name=calculator8888 calculatorwithwar'
    }
}

