def average_time_spent_online(users_information):
    total_time = 0
    num_users = len(users_information)

    for user in users_information:
        total_time += user['time_spent_online']

    average_time = total_time / num_users
    average_time_minutes = average_time / 60

    return average_time_minutes

