import time

f = open("src/time.txt", "r")
data = int(f.read())
data = int(time.time() - data)
f.close()

with open("src/time.txt", "w") as f:
    f.write(str(data))