import dictionary
import time

class Jumble(object):
    
    dictionary = dictionary.Dictionary()
    letters = []
    
    def __init__(self, letters):
        self.letters = letters
        
    def swap(self, i, j):
        '''
            swaps 2 letters in a list of letters
        '''
        temp = self.letters[i]
        self.letters[i] = self.letters[j]
        self.letters[j] = temp
    
    def jumble(self):
        if(self.dictionary.is_feasible(''.join(self.letters))):
            self._jumble(0)
        
    def _jumble(self, i):
        '''
            generates all permutations of the given letters and tries to find whether word exists within given dictionary
            the first 
        '''
        word = ''.join(self.letters[:i+1])
        
        #print "word ", word
        #on completion of permutation, check whether word exists in the dictionary
        if(i == len(self.letters)-1) and (self.dictionary.is_exists(word)):
            print word
            return
                
        #avoiding the permutation at initial levels, i.e. when fixed part of word (letters[0:i]) cannot exist in the dictionary
       ## elif(not self.dictionary.can_exists(word)):
         ###   return
        else:
            for j in range(i,len(self.letters)):
                # below condition handles went same alphabet appears mutliple times in a word
                if(i != j and self.letters[i] == self.letters[j]):
                    continue
                self.swap(i, j)
                word = ''.join(self.letters[:i+1])
                if(self.dictionary.can_exists(word)):
                    self._jumble(i+1)
                self.swap(i, j) # backtrack : fall backs to original arrangement of letters

# sample test case
if __name__ == '__main__':
    
    #input 1 : total execution time : 0.0320000648499 seconds # MODIFIED the dictionary to hold z to a forming word zyxwvutsrqponmlkjihgfedcba
    start_time = time.time()
    letters = list("zyxwvutsrqponmlkjihgfedcba")
    j = Jumble(letters)
    j.jumble()
    print "total execution time : %s seconds"%(time.time() - start_time)
    '''
    #input 2 : total execution time : 0.0 seconds
    start_time = time.time()
    j.letters = list('pneumonoultramicroscopicsilicovolcanoconiosis') # (46)longest word in english dictionary (= a supposed lung disease)
    j.jumble()
    print "total execution time : %s seconds"%(time.time() - start_time)'''