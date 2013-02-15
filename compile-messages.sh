if [ -z "$1" ]; then
   echo "Please specify which language_country suffix you want to compile (e.g. en_US, fr, etc.)"
   exit
fi

mkdir -p target/classes > /dev/null 2>&1

for lang in $*
do
  echo "Compiling $lang to package com.example.translations"
  msgfmt --verbose -f -r com.example.translations.messages --java2 -d target/classes \
         -l ${lang} msgs/${lang}.po
done
