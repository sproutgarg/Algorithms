import os.path

class Dictionary:
    dictionary = []
    
    def __init__(self):
        '''
        Loads the dictionary words
        '''
        try:
            source = os.path.dirname(__file__) + "\words.txt"
            file = open(source)
            self.dictionary = file.read().splitlines()
        except IOError, e:
            print "Fail to load Dictionary = >", e
        else:
            file.close()
        
    def is_exists(self, word):
        '''
        dictionary contains words in lexicographically order, therefore binary search is used to find the word in the dictionary
        '''
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

# sample test case
if __name__ == '__main__':
    d = Dictionary()
    print d.is_exists("zygote")