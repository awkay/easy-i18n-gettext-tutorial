if [ -z "$1" ]; then
   echo "Please specify which language_country suffix(es) you want to merge"
   exit
fi

for lang in $*
do
  echo "Initializing template file for $lang"
  if [ -f msgs/$lang.po ]; then
     echo "msgs/$lang.po exists! You probably wanted merge"
     exit
  fi
  msginit --no-translator -l $lang --no-wrap -o msgs/${lang}.po -i msgs/messages.pot
done
