import random

class Pokemon:
    counter = 0
    MAX_ATTACKS = 4

    def __init__(self, name, life_points):
        self.name = name
        self.life_points = life_points
        self.attacks = []
        Pokemon.counter += 1  # Incrémenter la variable de classe à chaque création

    def add_attack(self, attack):
        if len(self.attacks) < self.MAX_ATTACKS and attack not in self.attacks:
            self.attacks.append(attack)

    def heal(self, heal_amount):
        self.life_points += heal_amount

        for attack in self.attacks:
            attack.usage = 0

    def __str__(self):
        return f"Name: {self.name}\nLife Points: {self.life_points}\nNumber of Attacks: {len(self.attacks)}"
        
    def attack(self, target_pokemon):
        if not self.attacks:
            return

        available_attacks = [attack for attack in self.attacks if attack.usage < attack.usage_limit]
        if not available_attacks:
            return

        chosen_attack = random.choice(available_attacks)
        damage_dealt = chosen_attack.damages
        target_pokemon.life_points -= damage_dealt
        chosen_attack.usage += 1

class Attack:
    def __init__(self, name, damages, usage_limit=5):
        self.name = name
        self.damages = damages
        self.usage_limit = usage_limit
        self.usage = 0

    def __str__(self):
        return f"name: {self.name}\ndamage: {self.damages}\nusage: {self.usage}\nlimit: {self.usage_limit}"