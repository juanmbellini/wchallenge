# WChallenge [![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0) [![Build Status](https://travis-ci.org/juanmbellini/wchallenge.svg?branch=master)](https://travis-ci.org/juanmbellini/wchallenge)

Coding challenge by Wolox.


## Getting started

The following instructions will set the development environment in your local machine, 
as well as let you run locally an instance of the system.

**Note: This guide covers only Mac OS X setups.**


### Prerequisites

#### Get source code

Clone the repository or download source code:

```
$ git clone https://github.com/juanmbellini/wchallenge.git
```
or

```
$ wget https://github.com/juanmbellini/wchallenge/archive/master.zip
```

#### Set up Runtime

**This project requires Java 11**. The following is a guide to install Java 11, and optional ```jenv``` to manage your Java environments.


1.  **Install Java 11:**

    ```
    $ brew cask install java
    ```


    **Note:** If you already had a previous version of Java installed in your system, this will upgrade it. If you want to have several versions of Java installed in your machine, you can use the cask versions tap:


    1.  **Tap the cask versions repository:**

        ```
        $ brew tap homebrew/cask-versions
        ```
    2.  **Install a previous version of Java:**

        ```
        $ brew cask install java8
        ```

2.  **Install and configure jEnv (Optional):**

    Perform this step if you want to run multiple versions of Java in your machine. For more information, check [jEnv webpage](http://www.jenv.be/). Also, check [this guide](https://medium.com/@danielnenkov/multiple-jdk-versions-on-mac-os-x-with-jenv-5ea5522ddc9b).

    1.  **Download software:**

        ```
        $ brew install jenv
        ```

    2.  **Update your ```bash``` or ```zsh``` profile to use jEnv:**

        ##### Bash
        ```
        $ echo 'export PATH="$HOME/.jenv/bin:$PATH"' >> ~/.bash_profile
        $ echo 'eval "$(jenv init -)"' >> ~/.bash_profile
        ```

        If you want to use jEnv now, don't forget to source again your profile:

        ```
        $ source ~/.bash_profile
        ```

        ##### Zsh
        ```
        $ echo ‘export PATH=”$HOME/.jenv/bin:$PATH”’ >> ~/.zshrc
        $ echo ‘eval “$(jenv init -)”’ >> ~/.zshrc
        ```

        If you want to use jEnv now, don't forget to source again your profile:

        ```
        $ source ~/.zshrc
        ```

    3.  **Locate the JDK installations in your machine. They will likely be in the ```/Library/Java/JavaVirtualMachines/``` directory.**

    4.  **Add a Java version to jEnv:**

        ```
        $ jenv add /Library/Java/JavaVirtualMachines/{{jdk-version}}/Contents/Home
        ```
        Replace the ```{{jdk-version}}``` placeholder with an actual version of Java. For example:

        ```
        $ jenv add /Library/Java/JavaVirtualMachines/openjdk-11.0.2.jdk/Contents/Home
        ```

    5.  **Configure jEnv:**

        To set a global version of Java, use the following command:

        ```
        $ jenv global {{jdk-version}}
        ```
        Replace the ```{{jdk-version}}``` placeholder with an actual version of Java. For example:

        ```
        $ jenv global openjdk-11.0.2.jdk
        ```

        You can check the Java versions being managed by jEnv using the following command:

        ```
        $ jenv versions
        ```

        Similarly, you can set the Java Version with a local or shell scope:

        ##### Local Scope
        If you want to set the Java version for the current working directory:

        ```
        $ jenv local {{jdk-version}}
        ```
        ##### Shell Scope
        If you want to set the Java version for the current session:

        ```
        $ jenv shell {{jdk-version}}
        ```


#### Building tool

The building tool used for the project is Maven.

```
$ brew install maven
```

If you have installed jEnv, you can enable the maven plugin, in order to execute maven using the jEnv managed Java:

```
$ jenv enable-plugin maven
```

Restart your shell session in order to have the plugin running.

Check [this resource](https://github.com/gcuisinier/jenv#plugins) for more information about jEnv plugins.


#### Database

The project requires a PostgreSQL database.

##### Create a local database (Optional)

1. Install PostgreSQL

```
$ brew install postgresql
```

2. Create a user and a database for the application. You can check the [create user](https://www.postgresql.org/docs/9.6/static/sql-createuser.html) and [create database](https://www.postgresql.org/docs/9.6/static/sql-createdatabase.html) documentations to learn how to perform this step.


##### Set up project to use the database

Set the following properties with the appropiate values:

- ```spring.datasource.url```
- ```spring.datasource.username```
- ```spring.datasource.password```

You can do this by changing the ```<project-root>/wchallenge-application/src/main/resources/application.yml``` file, in the development section, or by defining the properties through the command line (with ```-Dkey=value``` properties, or with ```--key=value``` properties) when running the application.

**Note:** These properties can be filled with the values of a local database, or with the values of a remote database.



### Build

1. Install artifacts:

	```
	$ cd <project-root>
	$ mvn clean install
	```

	Doing this will allow you to use the modules defined in the project scope (i.e the submodules).

2. Build the project:

	```
	$ mvn clean pacakge
	```

	**Note:** In case you change the ```<project-root>/wchallenge-application/src/main/resources/application.yml```, you must build again the project. Otherwise, if you want to change a property on the fly, use command line properties.


### Run

You can run the application using the following command:

```
$ java [-Dkey=value properties] -jar <project-root>/wchallenge-application/target/wchallenge-application-0.0.1-SNAPSHOT.jar [--key=value properties]
```

The following is a full example of how to run the application:

```
java \
	-Dspring.datasource.url=jdbc:postgresql://localhost:5432/wchallenge \
	-Dspring.datasource.username=wchallenge \
	-Dspring.datasource.password=wchallenge \
	-jar <project-root>/wchallenge-application/target/wchallenge-application-0.0.1-SNAPSHOT.jar \
	--spring.profiles.active=dev
```

**Note:** In case of using a new database, this will create all tables.


## REST API Endpoints

### Json Placeholder Service Wrapper

This project creates an API that acts as a wrapper for the [Json Placeholder service](https://jsonplaceholder.typicode.com).


| Action            | HTTP Method   | Url                                   | Query Params  |
|:------------------|:--------------|:--------------------------------------|:--------------|
| Get all users     | GET           | /json-placeholder/users               | -             |
| Get all albums    | GET           | /json-placeholder/albums              | -             |
| Get all photos    | GET           | /json-placeholder/photos              | -             |
| Get user albums   | GET           | /json-placeholder/users/:id/albums    | -             |
| Get user photos   | GET           | /json-placeholder/users/:id/photos    | -             |
| Get user comments | GET           | /json-placeholder/users/:id/photos    | name, email   |


### Album Sharing Service

Another feature of the service is allowing users to share albums with other users, with READ and WRITE permissions.

| Action                            | HTTP Method   | Url                                       | Query Params  | Entity            |
|:----------------------------------|:--------------|:------------------------------------------|:--------------|-------------------|
| Grant permissions to user         | PUT           | /albums/:id/shares/:userId                | -             | PermissionList    |
| Remove permissions for user       | DELETE        | /albums/:id/shares/:userId                | -             | -                 |
| Grant permission to user          | PUT           | /albums/:id/shares/:userId/:permission    | -             | -                 |
| Remove permission for user        | DELETE        | /albums/:id/shares/:userId/:permission    | -             | -                 |
| Remove all permissions for album  | DELETE        | /albums/:id/shares/                       | -             | -                 |
| Remove all permissions for user   | DELETE        | /users/:id/permissions/                   | -             | -                 |
| Get users with permission         | GET           | /albums/:id/shares                        | permission    | -                 |


- **Permission path param:** The ```:permission``` path param valid values are ```READ``` and ```WRITE```.


#### Permission List Entity

- It is a JSON object that only contains a mandatory ```permissions``` field which is a list of permissions. 
- It must not be empty nor contain null elements.

##### Valid examples
```json
{
    "permissions": [
        "READ",
        "WRITE"
    ]
}

{
    "permissions": [
        "WRITE"
    ]
}
```

##### Invalid examples
```json
{
}

{
    "permissions": []
}

{
    "permissions": [
        "READ",
        null
    ]
}
```

## License

Copyright 2019 Juan Marcos Bellini

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

## Author

- [Juan Marcos Bellini](https://github.com/juanmbellini)
