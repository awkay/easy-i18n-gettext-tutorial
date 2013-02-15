# Easy i18n Tutorial Source

This project is meant to be used in conjunction with the 
[Easy i18n](https://github.com/awkay/easy-i18n) Library.

The example will work best on a system that supports Bash shell scripts,
since it uses those to make the process of extracting, merging, and
compiling the translations easier.

IMPORTANT: This code is NOT meant to compile cleanly without interaction from
the user (explained in the tutorial). Essentially, you'll need to, at a
minimum, extract the message strings, and initialize two language files.

For the impatient, this can be done with:

    ./extract.sh
    ./init.sh en fr

You can then edit the translations in msgs/fr.po, and build a runnable Jar with

    mvn clean package
