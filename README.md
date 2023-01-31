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

Where:

- `username` is the player name.

- `highscore` is a GTD key (Game Tracked Data).

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
            updatedAt=null
        ]
    ], 
    achievements=[]
]
```

> Your game must save the generated user ID in order to retrieve or update player statistics.

### Update user statistics

Code:

```java
// increase "username" with id "63d8f9d59f5e8817248b4577" highscore in 20 points
Stats stats = client.updateStats("63d8f9d59f5e8817248b4577", new HashMap<String, Object>() {{
    put("highscore", "+20");
}});
System.out.println(stats);
```

Where:

- `63d8f9d59f5e8817248b4577` is the generated user ID.

- `highscore` is the GTD key to be updated (in this case it is increaded in 20 points).

Output:

```
Stats [
    name=username, 
    id=63d8f9d59f5e8817248b4577, 
    values=[
        Value [
            key=highscore, 
            value=120, 
            sorting=desc, 
            rank=1, 
            updatedAt=2023-01-29T17:31:32
        ]
    ], 
    achievements=[]
]
```

### Get user statistics

Code:

```java
Stats stats = client.getStats("63d8f9d59f5e8817248b4577");
System.out.println(stats);
```

Where:

- `63d8f9d59f5e8817248b4577` is the generated user ID.

Output:

```
Stats [
    name=username, 
    id=63d8f9d59f5e8817248b4577, 
    values=[
        Value [
            key=highscore, 
            value=120, 
            sorting=desc, 
            rank=1, 
            updatedAt=2023-01-29T17:31:32
        ]
    ], 
    achievements=null
]

```

### Get user statistics section

Code:

```java
Section section = client.getStatsSection("63d8f9d59f5e8817248b4577", "highscore");
System.out.println(section);
```

Where:

- `63d8f9d59f5e8817248b4577` is the generated user ID.

Output:

```
Section [
	userRank=Rank [
    	name=username, 
        userProfile=null, 
        userIcon=null, 
        value=2150, 
        rank=2, 
        additionals=null
	], 
    ranks=[
    	Rank [
        	name=cnorris, 
        	userProfile=null, 
            userIcon=null, 
            value=8192, 
            rank=1, 
            additionals=null
		], 
        Rank [
        	name=username, 
            userProfile=null, 
            userIcon=null, 
            value=2150, 
            rank=2, 
            additionals=null
		], 
        Rank [
        	name=stallone, 
            userProfile=null, 
            userIcon=null, 
            value=201, 
            rank=3, 
            additionals=null
		], 
        Rank [
        	name=cbronson, 
            userProfile=null, 
            userIcon=null, 
            value=169, 
            rank=4, 
            additionals=null
		], 
        Rank [
        	name=vandamme, 
            userProfile=null, 
            userIcon=null, 
            value=123, 
            rank=5, 
            additionals=null
		]
	]
]
```

### Get leaderboard

Code:

```java
Stats stats = client.getLeaderboard("highscore", 3);
System.out.println(stats);
```

> `3` is the limit of results.

Output:

```
[
	Rank [
		name=cnorris, 
		userProfile=null, 
		userIcon=null, 
		value=8192, 
		rank=1, 
		additionals=null
	], 
	Rank [
		name=username, 
		userProfile=null, 
		userIcon=null, 
		value=2150, 
		rank=2, 
		additionals=null
	], 
	Rank [
		name=stallone, 
		userProfile=null, 
		userIcon=null, 
		value=201, 
		rank=3, 
		additionals=null
	]
]
```
