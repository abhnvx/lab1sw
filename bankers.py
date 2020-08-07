#OS LAB-3 ASSIGNMENT SUBBMITED BY ARJUN SETH(B1) BT18GCS122. (TOPIC- BANKERS ALGORITHM).
#FINAL SUBMISSION.
Process = 5
Resource = 3

def need_Calculation(need, max, allocation):
    for i in range(Process):
        for j in range(Resource):
            need[i][j] = max[i][j] - allocation[i][j]

def safe_Check(processes, available, max, allocation):
    need = []
    for i in range(Process):
        l = []
        for j in range(Resource):
            l.append(0)
        need.append(l)
    need_Calculation(need, max, allocation)
    process_Completion = [0] * Process
    safe_Sequence = [0] * Process

    process_Work = [0] * Resource
    for i in range(Resource):
        process_Work[i] = available[i]

    check_P = 0
    while (check_P < Process):
        uncomp_Proc = False
        for p in range(Process):
            if (process_Completion[p] == 0):
                for j in range(Resource):
                    if (need[p][j] > process_Work[j]):
                        break
                    
                if (j == Resource - 1):
                    for k in range(Resource):
                        process_Work[k] += allocation[p][k]
                    safe_Sequence[check_P] = p
                    check_P += 1
                    process_Completion[p] = 1
                    uncomp_Proc = True
                
        if (uncomp_Proc == False):
            print("SYSTEM IS NOT IN SAFE STATE: DEADLOCK DETECTED.")
            return False
        
    print("SYSTEM IS IN SAFE STATE.",
            "\nSAFE SEQUENCE OF PROCESSCES ARE: ", end = " ")
    print(*safe_Sequence)
    return True


if __name__ =="__main__":
    processes = [0, 1, 2, 3, 4]
    available = [3, 3, 2]
    max = [[7, 5, 3], [3, 2, 2],
            [9, 0, 2], [2, 2, 2],
            [4, 3, 3]]
    allocation = [[0, 1, 0], [2, 0, 0],
            [3, 0, 2], [2, 1, 1],
            [0, 0, 2]]
    safe_Check(processes, available, max, allocation)


