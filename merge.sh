if [ -z "$1" ]; then
   echo "Please specify which language_country suffix(es) you want to merge"
   exit 1
fi

for lang in $*
do
  echo "Merging template file into $lang"
  msgmerge -i -F --no-wrap -o msgs/${lang}.po msgs/${lang}.po msgs/messages.pot
done
