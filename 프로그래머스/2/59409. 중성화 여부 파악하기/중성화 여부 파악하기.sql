select 
ANIMAL_ID, 
NAME, 
IF(SEX_UPON_INTAKE like '%Neutered%' or SEX_UPON_INTAKE like '%Spayed%', 'O', 'X') AS '중성화'
from ANIMAL_INS;
