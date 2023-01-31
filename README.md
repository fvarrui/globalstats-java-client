# globalstats-java-client

[![Maven Central](http://img.shields.io/maven-central/v/io.github.fvarrui/globalstats-java-client)](https://search.maven.org/artifact/io.github.fvarrui/globalstats-java-client)
[![GPL-3.0](https://img.shields.io/badge/license-GPL--3.0-%250778B9.svg)](https://www.gnu.org/licenses/gpl-3.0.html)

[GlobalStats.io](https://globalstats.io/) API client in Java for saving and sharing your games statistics.

## Use it in Maven

```xml
<dependency>
    <groupId>io.github.fvarrui</groupId>
    <artifactId>globalstats-java-client</artifactId>
    <version>{latest.version}</version>
</dependency>
```

## Use it in Gradle

```groovy
implementation 'io.github.fvarrui:globalstats-java-client:{latest.version}'
```

## Build and install it to your local Maven repo

```bash
git clone https://github.com/fvarrui/globalstats-java-client.git [--branch devel]
cd globalstats-java-client
./mvn install
```

> Omits `./` on Windows.
> 
> Use `--branch devel` option for SNAPSHOT versions.

## Usage examples

### Get access token

Code:

```java
GlobalStats client = new GlobalStats(clientId, clientSecret);
String token = client.getAccessToken();
System.out.println(token);
```

Output:

```
qV4U8NhsFZy8R3M6EQoJYEhE1IroskmOBdUZlkgn
```

### Create new user statistics

Code:

```java
Stats stats = client.createStats("username", new HashMap<String, Object>() {{
    put("highscore", 100);
}});
System.out.println(stats);
```

Output:

```
Stats [
    name=username, 
    id=63d8f9d59f5e8817248b4577, 
    values=[
        Value [
            key=highscore, 
            value=100, 
            sorting=desc, 
            rank=7, 
            updatedAt=null]
    ], 
    achievements=[]
]
```

[...]
