import urllib.request 
import re

url = "https://liveexample.pearsoncmg.com/data/Lincoln.txt"
count = 0
word_count = 0

try: #classic tryCatch blocks but keyword in python is except
    with urllib.request.urlopen(url) as response: #using urllib as imported library to open as url
        for line in response:
            line = line.decode('utf-8') #This decodes the bytes into strings from txt file
            count+= len(line) #adds length of line to character count
            words = re.split(r'\s', line.strip()) #re library process regex. This command here splits the lines into words and ignores whitespace
            word_count += len(words) #adds length of words in line to word count
    print(f"The file size is {count} characters and {word_count} words.") #print final word count to console
except urllib.error.URLError as e: #invalid URL exception
    print("Invalid URL")
except Exception as e: #invalid Input exception
    print("IO Errors")
