from pokemon import Pokemon

def test_Pokemon():
    
    
    p1 = Pokemon("poulet", 100)
    assert p1.name == "poulet"