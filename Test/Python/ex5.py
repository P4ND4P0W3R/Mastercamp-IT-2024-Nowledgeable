from datetime import datetime, timedelta

def find_common_slots(slots1, slots2):
    common_slots = []
    
    for slot1 in slots1:
        for slot2 in slots2:
            start1 = datetime.strptime(slot1[0], "%H:%M")
            end1 = datetime.strptime(slot1[1], "%H:%M")
            start2 = datetime.strptime(slot2[0], "%H:%M")
            end2 = datetime.strptime(slot2[1], "%H:%M")
            if start1 < end2 and start2 < end1:
                start = max(start1, start2)
                end = min(end1, end2)
                common_slots.append((start.strftime("%H:%M"), end.strftime("%H:%M")))
    
    return common_slots