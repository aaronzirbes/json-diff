# json-diff

A library for generating a JSON changelog

## Usage

See the [Specification](src/test/groovy/org/zirbes/json/diff/JsonDiffSpec.groovy) for details.

## Sample Output

Trimmed output from diff-ing the commits from a
[GitHub repo commit history](https://api.github.com/repos/aaronzirbes/terraform-sandbox/commits)


    @@ 742ae818ae44d450420022310b253ee5f90ea514
    - "commit.author.date": "2015-01-11T08:09:07Z"
    + "commit.author.date": "2015-01-02T22:31:02Z"
    - "commit.message": "Adding NAT, Bastion and routing tables"
    + "commit.message": "progress"
    - "commit.tree.sha": "3798e065641aa2886d97f321afda7a376b184c2b"
    + "commit.tree.sha": "b34bff655a8fcb28488bf73c9e884176a95cf5f8"
    - "sha": "74846902fe120ffd65162bcfb5459d87ab7c4842"
    + "sha": "742ae818ae44d450420022310b253ee5f90ea514"
    @@ 74846902fe120ffd65162bcfb5459d87ab7c4842
    - "commit.author.date": "2015-01-12T01:16:37Z"
    + "commit.author.date": "2015-01-11T08:09:07Z"
    - "commit.message": "stablizing destroy"
    + "commit.message": "Adding NAT, Bastion and routing tables"
    - "commit.tree.sha": "1ef6c940e675554211988ef6eaeb9d6d9d01db2b"
    + "commit.tree.sha": "3798e065641aa2886d97f321afda7a376b184c2b"
    - "sha": "90cdff26502839b4d5565dfcf4bdc60098852c81"
    + "sha": "74846902fe120ffd65162bcfb5459d87ab7c4842"
    @@ 90cdff26502839b4d5565dfcf4bdc60098852c81
    - "commit.author.date": "2015-01-12T05:20:27Z"
    + "commit.author.date": "2015-01-12T01:16:37Z"
    - "commit.message": "Addong consul by hand"
    + "commit.message": "stablizing destroy"
    - "commit.tree.sha": "81d9986f6b18f7d9e88d6559993416e8d435fcbb"
    + "commit.tree.sha": "1ef6c940e675554211988ef6eaeb9d6d9d01db2b"
    - "sha": "1ed9a86160dfeca6b4d4c25a996ff01f37a85115"
    + "sha": "90cdff26502839b4d5565dfcf4bdc60098852c81"
    @@ c101307357806a5993e0876c6626e46929108f12
    - "commit.author.date": "2015-01-02T22:31:02Z"
    + "commit.author.date": "2015-01-01T19:52:33Z"
    - "commit.message": "progress"
    + "commit.message": "Initial commit"
    - "commit.tree.sha": "b34bff655a8fcb28488bf73c9e884176a95cf5f8"
    + "commit.tree.sha": "faf657e71d419ad145e6f892f41d84a30c924105"
    - "sha": "742ae818ae44d450420022310b253ee5f90ea514"
    + "sha": "c101307357806a5993e0876c6626e46929108f12"
