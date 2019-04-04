## Release Checklist

1. Increment version in `README.md`, `gradle.build`


3. Update [CHANGES.md](./CHANGES.md)

<!--4. Push and wait for travis CI results-->

5. Do the release

```bash
export JB_HOME=" /d/projects/misc/jsonbuilder";

trim() { while read -r line; do echo "$line"; done; }
jb_version=$(grep '^version' ${JB_HOME}/build.gradle | cut -f2 -d' ' | tr -d "'" | trim)

echo "new version is $jb_version"

source ~/archive/gh_token.sh
export GITHUB_TOKEN=${GH_TOKEN}
#echo $GITHUB_TOKEN

# make your tag and upload
cd ${JB_HOME}

#git tag v${jb_version} && git push --tags
(git diff --ignore-submodules --exit-code && git tag "v${jb_version}")  || echo "could not tag current branch"

git push
git push --tags

# check the current tags and existing releases of the repo
# binaries are located under $GOPATH/bin
export PATH=~/go/bin/:$PATH
github-release info -u holgerbrandl -r jsonbuilder

# create a formal release
github-release release \
    --user holgerbrandl \
    --repo jsonbuilder \
    --tag "v${jb_version}" \
    --name "v${jb_version}" \
    --description "See [CHANGES.md](https://github.com/holgerbrandl/jsonbuilder/blob/master/CHANGES.md) for changes."
#    --pre-release


########################################################################
### Build and publish the binary release to jcenter

gradle install

# careful with this one!
gradle bintrayUpload
```

For released versions check:

- https://bintray.com/holgerbrandl/mpicbg-scicomp/krangl
- https://jcenter.bintray.com/de/mpicbg/scicomp/krangl/

--

4. Increment version to *-SNAPSHOT for next release cycle

