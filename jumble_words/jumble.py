import dictionary

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
        self._jumble(0)
        
    def _jumble(self, i):
        '''
            generates all permutations of the given letters and tries to find whether word exists within given dictionary
        '''
        if(i == len(self.letters)-1):
            word = ''.join(self.letters).lower()
            if (self.dictionary.is_exists(word)):
                print word
        else:
            for j in range(i,len(self.letters)):
                # below condition handles went same alphabet appears mutliple times in a word
                if(i != j and self.letters[i] == self.letters[j]):
                    continue
                self.swap(i, j);
                self._jumble(i+1);
                self.swap(i, j); # backtrack : fall backs to original arrangement of letters
            
# sample test case
if __name__ == '__main__':
    letters = ['a', 'b', 'a']
    j = Jumble(letters)
    j.jumble()