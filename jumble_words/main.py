import sys
import jumble
import time

def main(letters):
    j = jumble.Jumble(letters)
    j.jumble();
    return

def help():
    print 'syntax  : cmd-prompt> python main.py <series of alphabets WITHOUT spaces>\n'\
          'example : cmd-prompt> python main.py nyhtpo'
    return

def validate_input(input):
    if(len(input) == 0):
        print 'No input given'
        return False
    elif not all(c.isalpha() for c in input):
        print 'Non alphabetic charater entered as an input'
        return False
    return True

if __name__ == '__main__':
    start_time = time.time()
    input = sys.argv[1:]
    if(validate_input(input)):
        main(input)
    else:
        help()
    print "total execution time : %s seconds"%(time.time() - start_time)