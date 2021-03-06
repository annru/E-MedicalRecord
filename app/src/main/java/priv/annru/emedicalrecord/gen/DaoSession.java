package priv.annru.emedicalrecord.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import priv.annru.emedicalrecord.model.MedicalRecord;
import priv.annru.emedicalrecord.model.User;

import priv.annru.emedicalrecord.gen.MedicalRecordDao;
import priv.annru.emedicalrecord.gen.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig medicalRecordDaoConfig;
    private final DaoConfig userDaoConfig;

    private final MedicalRecordDao medicalRecordDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        medicalRecordDaoConfig = daoConfigMap.get(MedicalRecordDao.class).clone();
        medicalRecordDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        medicalRecordDao = new MedicalRecordDao(medicalRecordDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(MedicalRecord.class, medicalRecordDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        medicalRecordDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public MedicalRecordDao getMedicalRecordDao() {
        return medicalRecordDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
