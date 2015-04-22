import sys
import jumble

def main(letters):
    j = jumble.Jumble(letters)
    j.jumble();
    return

def help():
    print 'syntax  : cmd-prompt> python main.py <series of alphabets separated by spaces>\n'\
          'example : cmd-prompt> python main.py n y h t p o'
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
    input = sys.argv[1:]
    if(validate_input(input)):
        main(input)
    else:
        help()