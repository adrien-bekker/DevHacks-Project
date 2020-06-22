import time

with open("src/time.txt", "w") as f:
    f.write(str(int(time.time())))