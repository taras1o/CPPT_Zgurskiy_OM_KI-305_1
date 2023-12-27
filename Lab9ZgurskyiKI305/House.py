House.py
import datetime

class House:
    def __init__(self, address="No information", number_of_floors=0, has_garden=False):
        self.address = address
        self.number_of_floors = number_of_floors
        self.has_garden = has_garden
        self.writer = None

    def open_log_file(self):
        try:
            self.writer = open("log.txt", "a")
        except IOError as e:
            print(f"Помилка при відкритті файлу для запису: {e}")

    def close_log_file(self):
        try:
            if self.writer:
                self.writer.close()
        except IOError as e:
            print(f"Помилка при закритті файлу: {e}")

    def display_details(self):
        print(f"Адреса будинку: {self.address}")
        print(f"Кількість поверхів: {self.number_of_floors}")
        print(f"Наявність саду: {'Так' if self.has_garden else 'Ні'}")

    def log_message(self, message):
        try:
            if self.writer:
                timestamp = datetime.datetime.now()
                self.writer.write(f"[{timestamp}] {message} - {self}\n")
        except IOError as e:
            print(f"Помилка при записі до файлу: {e}")

    def set_number_of_floors(self, number_of_floors):
        self.number_of_floors = number_of_floors
        self.log_message(f"Встановлено кількість поверхів: {number_of_floors}")

    def set_address(self, address):
        self.address = address
        self.log_message(f"Оновлено адресу: {address}")

    def set_has_garden(self, has_garden):
        self.has_garden = has_garden
        self.log_message("Оновлено інформацію про сад.")

    def add_floor(self):
        self.number_of_floors += 1
        self.log_message("Додано поверх.")

    def remove_floor(self):
        if self.number_of_floors > 0:
            self.number_of_floors -= 1
            self.log_message("Видалено поверх.")
        else:
            self.log_message("Не можна видалити поверх. Кількість поверхів вже мінімальна.")

    def get_number_of_floors(self):
        self.log_message("Дана інформація про кількість поверхів.")
        return self.number_of_floors

    def get_address(self):
        return self.address

    def has_garden(self):
        self.log_message("Дана інформація про наявність саду.")
        return self.has_garden















HouseApp.py:
from house import House

class HouseApp:
    def main(self):
        # Create a house
        house = House("123 Main St.", 2, True)

        # Display house details
        house.display_details()

        # Update house details
        house.set_number_of_floors(3)
        house.set_address("456 Elm St.")
        house.set_has_garden(False)

        # Display updated house details
        house.display_details()

        house.to_string()

if __name__ == "__main__":
    app = HouseApp()
    app.main()









OfficeCenter.py:
from house import House
import datetime

class OfficeCenter(House):
    def __init__(self, address, number_of_floors, office_space, has_meeting_room, number_of_desks, has_projector, has_whiteboard):
        super().__init__(address, number_of_floors)
        self.office_space = office_space
        self.has_meeting_room = has_meeting_room
        self.number_of_desks = number_of_desks
        self.has_projector = has_projector
        self.has_whiteboard = has_whiteboard

    def get_office_space(self):
        return self.office_space

    def set_office_space(self, office_space):
        self.office_space = office_space

    def allocate_office_space(self, square_meters):
        self.office_space += square_meters

    def equip_meeting_room(self, projector, whiteboard):
        self.has_meeting_room = True
        self.has_projector = projector
        self.has_whiteboard = whiteboard

    def add_desks(self, desks_to_add):
        self.number_of_desks += desks_to_add

    def remove_desks(self, desks_to_remove):
        if desks_to_remove > self.number_of_desks:
            print("Cannot remove more desks than available.")
        else:
            self.number_of_desks -= desks_to_remove

    def add_projector(self, has_projector):
        self.has_projector = has_projector

    def add_whiteboard(self, has_whiteboard):
        self.has_whiteboard = has_whiteboard

    def add_projector2(self, has_projector):
        print("Projector was added")
        has_projector = True

    def write_address_to_file(self):
        address = self.get_address()

        try:
            with open("Address.txt", "w") as writer:
                writer.write(address)
        except IOError as e:
            print(f"Помилка при записі у файл: {e}")

        return address

    def __str__(self):
        return self.write_address_to_file()










OfficeInterface.py:
class OfficeInterface:
    def get_office_space(self):
        pass

    def set_office_space(self, office_space):
        pass

    def allocate_office_space(self, square_meters):
        pass

    def equip_meeting_room(self, projector, whiteboard):
        pass

    def add_desks(self, desks_to_add):
        pass

    def remove_desks(self, desks_to_remove):
        pass

    def add_projector(self, has_projector):
        pass

    def add_whiteboard(self, has_whiteboard):
        pass

    def write_address_to_file(self):
        pass









OfficeInterface2.py:
class OfficeInterface2:
    def add_projector2(self, has_projector):
        pass

    def add_whiteboard2(self, has_whiteboard):
        pass
