package uz.personal.cleanarchitectureandroid.data.repository

import uz.personal.cleanarchitectureandroid.data.storage.room.RoomDaoInterface
import uz.personal.cleanarchitectureandroid.data.storage.room.models.SmartPhone
import uz.personal.cleanarchitectureandroid.domain.modules.SmartPhoneDomain
import uz.personal.cleanarchitectureandroid.domain.repository.SmartPhoneRepository

class RoomRepositoryImpl(private var roomDao: RoomDaoInterface) : SmartPhoneRepository {
    override suspend fun readSmartPhone(): ArrayList<SmartPhoneDomain> {
        val list = roomDao.read()
        val returnList = ArrayList<SmartPhoneDomain>()
        list.forEach { smartPhone ->
            returnList.add(
                SmartPhoneDomain(
                    id = smartPhone.id,
                    name = smartPhone.productName,
                    price = smartPhone.productPrice)
            )
        }
        return returnList
    }

    override suspend fun addSmartPhone(smartPhoneDomain: SmartPhoneDomain) {
        val smartPhone =
            SmartPhone(id = smartPhoneDomain.id,
                productName = smartPhoneDomain.name,
                productPrice = smartPhoneDomain.price
            )
        roomDao.saveData(smartPhone = smartPhone)
    }

    override suspend fun removeSmartPhone(smartPhoneDomain: SmartPhoneDomain) {
        val smartPhone =
            SmartPhone(id = smartPhoneDomain.id,
                productName = smartPhoneDomain.name,
                productPrice = smartPhoneDomain.price
            )

        roomDao.delete(smartPhone = smartPhone)
    }

    override suspend fun updateSmartPhone(smartPhoneDomain: SmartPhoneDomain) {
        val smartPhone =
            SmartPhone(id = smartPhoneDomain.id,
                productName = smartPhoneDomain.name,
                productPrice = smartPhoneDomain.price
            )
        roomDao.update(smartPhone = smartPhone)
    }
}