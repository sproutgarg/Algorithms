import os.path
import decimal
import time

class Dictionary:
    dictionary = []
    max_word_length = decimal.Decimal('-infinity')
    
    def __init__(self):
        '''
        Loads the dictionary words
        '''
        try:
            #removed directory dependency based on OS
            source = os.path.join(os.path.dirname(__file__), "words.txt")
            file = open(source)
            self.dictionary = file.read().splitlines()
        except IOError, e:
            print "Fail to load Dictionary = >", e
        else:
            file.close()
            self.update_length_of_longest_word()
        return
            
    def update_length_of_longest_word(self):
        '''
        Finds and stores the length of the longest string in the dictionary
        '''
        for line in self.dictionary:
            if(len(line) > self.max_word_length):
                self.max_word_length = len(line)
        return
    
    def is_exists(self, word):
        '''
        dictionary contains words in lexicographically order, therefore binary search is used to find the word in the dictionary
        '''
        if(not self.is_feasible(word)):
            return False

        low, high = 0, len(self.dictionary)-1
        
        while(low<=high):
            mid = low + (high-low)/2
            if(self.dictionary[mid] == word):
                return True
            elif (self.dictionary[mid] < word):
                low = mid+1
            else:
                high = mid-1
        return False
    
    def can_exists(self, partial_word):
        '''
        Searches existence of partial_word (which may or may not be legal word) in the dictionary
        '''
        if(not self.is_feasible(partial_word)):
            return False
        
        low, high, mid = 0, len(self.dictionary)-1, 0

        while(low<=high):
            mid = low + (high-low)/2
            if(partial_word in self.dictionary[mid]):
                return True
            elif (self.dictionary[mid] < partial_word):
                low = mid+1
            else:
                high = mid-1
        return False                

    def is_feasible(self, word):
        '''
        Check whether dictionary holds the english-words of length greater than equal to the input partial_word's length
        '''
        return self.max_word_length >= len(word)
    
# sample test case
if __name__ == '__main__':
    d = Dictionary()
    #print d.is_exists("zygote")
    start_time = time.time()
    str = "abcdefghijklmnopqrstuvwxyz"
    print d.can_exists(str)
    rstr=str[::-1]
    print d.can_exists(rstr)
    print "total execution time : %s seconds"%(time.time() - start_time)