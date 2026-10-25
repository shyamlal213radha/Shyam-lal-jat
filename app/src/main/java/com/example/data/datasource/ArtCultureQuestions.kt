package com.example.data.datasource

import com.example.data.model.Category
import com.example.data.model.Question
import com.example.data.model.Topic

object ArtCultureQuestions {
    val list: List<Question> = listOf(
        // LOK DEVTA & KUL DEVIS
        Question(
            id = 201,
            questionText = "ऊंटों के देवता, प्लेग रक्षक और लक्ष्मण के अवतार के रूप में किस लोक देवता की पूजा की जाती है?",
            options = listOf("पाबूजी राठौड़", "रामदेव जी", "गोगाजी", "तेजाजी"),
            correctAnswerIndex = 0,
            explanation = "पाबूजी राठौड़ (कोलू फलौदी) को ऊंटों के देवता, प्लेग रक्षक, हाड़-फाड़ के देवता तथा लक्ष्मण का अवतार माना जाता है। इनकी घोड़ी का नाम 'केसर कालमी' था।",
            category = Category.ART_CULTURE,
            topic = Topic.LOK_DEVTA_DEVI
        ),
        Question(
            id = 202,
            questionText = "लोक देवता रामदेव जी द्वारा किस पंथ की स्थापना की गई थी, जिसके भजनों पर तेरहताली नृत्य किया जाता है?",
            options = listOf("कामड़िया पंथ", "कुंडा पंथ", "निरंजनी पंथ", "अलखिया पंथ"),
            correctAnswerIndex = 0,
            explanation = "रामदेव जी ने कामड़िया पंथ की स्थापना की थी। कामड़ जाति की महिलाओं द्वारा रामदेवरा मेले में बैठकर मंजीरों के साथ प्रसिद्ध 'तेरहताली नृत्य' किया जाता है।",
            category = Category.ART_CULTURE,
            topic = Topic.LOK_DEVTA_DEVI
        ),
        Question(
            id = 203,
            questionText = "गोगाजी का मुख्य जन्म स्थल 'शीर्षमेड़ी' और मुख्य समाधि स्थल 'धुरमेड़ी' क्रमशः कहां स्थित हैं?",
            options = listOf("ददरेवा (चूरू) और गोगामेड़ी (हनुमानगढ़)", "कोलू (फलौदी) और रुणेचा (जैसलमेर)", "खड़नाल और परबतसर (नागौर)", "आसींद और देवमाली"),
            correctAnswerIndex = 0,
            explanation = "गोगाजी का जन्म स्थल ददरेवा (चूरू) शीर्षमेड़ी कहलाता है और गोगामेड़ी (हनुमानगढ़) धुरमेड़ी कहलाता है। महमूद गजनवी ने इन्हें 'जाहर पीर' कहा था।",
            category = Category.ART_CULTURE,
            topic = Topic.LOK_DEVTA_DEVI
        ),
        Question(
            id = 204,
            questionText = "राजस्थान में किस लोक देवता के मंदिर में उनकी 'बैलगाड़ी' की पूजा की जाती है?",
            options = listOf("हड़बूजी सांखला", "मेहाजी मांगलिया", "मल्लीनाथ जी", "देव बाबा"),
            correctAnswerIndex = 0,
            explanation = "हड़बूजी सांखला (बेंगटी, फलौदी) के मंदिर में उनकी बैलगाड़ी की पूजा की जाती है, जिससे वे पंगु गायों के लिए घास लाया करते थे। इनका वाहन सियार है।",
            category = Category.ART_CULTURE,
            topic = Topic.LOK_DEVTA_DEVI
        ),
        Question(
            id = 205,
            questionText = "राजस्थान में 'चार हाथों वाले देवता' और शेषनाग के अवतार के रूप में कौन पूजे जाते हैं?",
            options = listOf("वीर कल्ला जी राठौड़", "वीर फत्ता जी", "तेजाजी", "आलम जी"),
            correctAnswerIndex = 0,
            explanation = "वीर कल्ला जी राठौड़ को चार हाथों वाले देवता और शेषनाग का अवतार माना जाता है। इन्होंने 1568 ई. में अकबर के विरुद्ध चित्तौड़ दुर्ग में जयमल को कंधे पर बैठाकर युद्ध किया था।",
            category = Category.ART_CULTURE,
            topic = Topic.LOK_DEVTA_DEVI
        ),
        Question(
            id = 206,
            questionText = "बीकानेर के राठौड़ वंश की कुलदेवी एवं चूहों वाली देवी के रूप में कौन प्रसिद्ध हैं?",
            options = listOf("करणी माता (देशनोक)", "जीण माता (रैवासा)", "कैला देवी (करौली)", "सच्चियाय माता (ओसियां)"),
            correctAnswerIndex = 0,
            explanation = "देशनोक (बीकानेर) स्थित करणी माता के मंदिर में सफेद चूहों (काबा) के दर्शन शुभ माने जाते हैं। यह बीकानेर के राठौड़ों की आराध्य देवी हैं।",
            category = Category.ART_CULTURE,
            topic = Topic.LOK_DEVTA_DEVI
        ),
        Question(
            id = 207,
            questionText = "करौली के यदुवंशी यादवों की कुलदेवी कौन हैं, जिनके मेले में 'लांगुरिया नृत्य' किया जाता है?",
            options = listOf("कैला देवी", "आईजी माता", "नारायणी माता", "सकराय माता"),
            correctAnswerIndex = 0,
            explanation = "करौली की कैला देवी यादव वंश की कुलदेवी हैं। इनके चैत्र नवरात्र मेले में श्रद्धालु भक्तिभाव से 'लांगुरिया' गीत व नृत्य करते हैं।",
            category = Category.ART_CULTURE,
            topic = Topic.LOK_DEVTA_DEVI
        ),
        Question(
            id = 208,
            questionText = "जोधपुर के राठौड़ राजवंश की कुलदेवी कौन हैं?",
            options = listOf("नागणेची माता", "बाणमाता", "जमवाय माता", "त्रिपुरा सुंदरी"),
            correctAnswerIndex = 0,
            explanation = "जोधपुर के राठौड़ों की कुलदेवी नागणेची माता हैं, जबकि मेवाड़ के सिसोदिया राजवंश की कुलदेवी बाणमाता (बरवड़ माता) हैं।",
            category = Category.ART_CULTURE,
            topic = Topic.LOK_DEVTA_DEVI
        ),

        // SANTS & SECTS
        Question(
            id = 209,
            questionText = "संत जाम्भोजी ने विश्नोई संप्रदाय के प्रवर्तन हेतु कितने नियमों की आचार संहिता बनाई थी?",
            options = listOf("29 नियम (20+9)", "36 नियम", "42 नियम", "52 नियम"),
            correctAnswerIndex = 0,
            explanation = "संत जाम्भोजी ने 1485 ई. में 29 नियम (20+9) चलाए, जिन्हें मानने वाले 'विश्नोई' कहलाते हैं। इनका प्रमुख समाधि स्थल मुकाम तालवा (बीकानेर) है।",
            category = Category.ART_CULTURE,
            topic = Topic.SANTS_SECTS
        ),
        Question(
            id = 210,
            questionText = "36 नियमों का पालन करने वाले जसनाथी संप्रदाय के सिद्ध पुरुषों द्वारा कौन-सा प्रसिद्ध नृत्य किया जाता है?",
            options = listOf("अग्नि नृत्य (धधकते अंगारों पर)", "चरी नृत्य", "घूमर नृत्य", "वालर नृत्य"),
            correctAnswerIndex = 0,
            explanation = "संत जसनाथ जी (कतरियासर, बीकानेर) द्वारा स्थापित जसनाथी संप्रदाय में 36 नियम होते हैं। इनके अनुयायी 'फतेह-फतेह' बोलते हुए अंगारों पर अग्नि नृत्य करते हैं।",
            category = Category.ART_CULTURE,
            topic = Topic.SANTS_SECTS
        ),
        Question(
            id = 211,
            questionText = "दादू पंथ की मुख्य गद्दी (प्रधान पीठ) कहां स्थित है?",
            options = listOf("नारायणा (जयपुर)", "सलेमाबाद (अजमेर)", "कतरियासर (बीकानेर)", "शाहपुरा (भीलवाड़ा)"),
            correctAnswerIndex = 0,
            explanation = "राजस्थान के कबीर कहलाने वाले संत दादू दयाल के दादू पंथ की प्रमुख गद्दी नारायणा (जयपुर) में स्थित है। दादू जी के उपदेश ढूंढाड़ी/सधुक्कड़ी भाषा में हैं।",
            category = Category.ART_CULTURE,
            topic = Topic.SANTS_SECTS
        ),
        Question(
            id = 212,
            questionText = "रामस्नेही संप्रदाय की प्रधान पीठ शाहपुरा (भीलवाड़ा) में कौन-सा प्रसिद्ध महोत्सव मनाया जाता है?",
            options = listOf("फूलडोल महोत्सव", "महामस्तकाभिषेक", "सांझी महोत्सव", "हिंडोला महोत्सव"),
            correctAnswerIndex = 0,
            explanation = "संत रामचरण जी द्वारा प्रवर्तित रामस्नेही संप्रदाय की शाहपुरा शाखा में चैत्र कृष्ण प्रतिपदा से पंचमी तक 'फूलडोल महोत्सव' मनाया जाता है।",
            category = Category.ART_CULTURE,
            topic = Topic.SANTS_SECTS
        ),
        Question(
            id = 213,
            questionText = "'राजस्थान की मरू कोकिला' के उपनाम से प्रसिद्ध मांड गायिका कौन हैं जिन्हें 1982 में पद्मश्री मिला?",
            options = listOf("अल्लाह जिल्लाई बाई (बीकानेर)", "मांगी बाई", "बन्नो बेगम", "गवरी देवी"),
            correctAnswerIndex = 0,
            explanation = "अल्लाह जिल्लाई बाई (बीकानेर) ने प्रसिद्ध मांड गीत 'केसरिया बालम आओ नी पधारो म्हारे देस' को अंतरराष्ट्रीय ख्याति दिलाई। इन्हें 1982 में पद्मश्री मिला था।",
            category = Category.ART_CULTURE,
            topic = Topic.SANTS_SECTS
        ),

        // DANCE & MUSIC & INSTRUMENTS
        Question(
            id = 214,
            questionText = "गरासिया जनजाति का प्रसिद्ध युगल नृत्य कौन-सा है जिसे बिना किसी वाद्य यंत्र के लयबद्ध तरीके से किया जाता है?",
            options = listOf("वालर नृत्य", "मांदल नृत्य", "लूर नृत्य", "शिकारी नृत्य"),
            correctAnswerIndex = 0,
            explanation = "वालर नृत्य गरासिया जनजाति का सबसे प्रसिद्ध नृत्य है। इसे 'गरासियों की घूमर' भी कहा जाता है और यह बिना वाद्य यंत्र के मंद गति में किया जाता है।",
            category = Category.ART_CULTURE,
            topic = Topic.DANCE_MUSIC_INSTRUMENTS
        ),
        Question(
            id = 215,
            questionText = "किशनगढ़ की फलकू बाई किस प्रसिद्ध नृत्य की नृत्यांगना हैं?",
            options = listOf("चरी नृत्य (गुर्जर जाति)", "कालबेलिया नृत्य", "भवाई नृत्य", "तेरहताली नृत्य"),
            correctAnswerIndex = 0,
            explanation = "चरी नृत्य गुर्जर जाति की महिलाओं द्वारा सिर पर पीतल की चरी में कपास के जलते बीज रखकर किया जाता है, जिसकी विख्यात नृत्यांगना फलकू बाई हैं।",
            category = Category.ART_CULTURE,
            topic = Topic.DANCE_MUSIC_INSTRUMENTS
        ),
        Question(
            id = 216,
            questionText = "राजस्थान का राज्य वाद्य यंत्र कौन-सा है जो सुषिर (फूंक मारकर बजाने वाला) वाद्य यंत्र है?",
            options = listOf("अलगोजा", "रावणहत्था", "कमायचा", "शहनाई"),
            correctAnswerIndex = 0,
            explanation = "अलगोजा दो बांसुरियों को मुंह में रखकर एक साथ बजाया जाने वाला सुषिर वाद्य यंत्र है और यह राजस्थान का राज्य वाद्य यंत्र है।",
            category = Category.ART_CULTURE,
            topic = Topic.DANCE_MUSIC_INSTRUMENTS
        ),
        Question(
            id = 217,
            questionText = "पाबूजी की फड़ बांचते समय भोपों द्वारा किस तत् वाद्य यंत्र का मुख्य रूप से प्रयोग किया जाता है?",
            options = listOf("रावणहत्था", "जंतर", "सारंगी", "एकतारा"),
            correctAnswerIndex = 0,
            explanation = "पाबूजी की फड़ के वाचन में रावणहत्था वाद्य यंत्र का प्रयोग होता है, जबकि देवनारायण जी की फड़ में 'जंतर' वाद्य यंत्र का उपयोग किया जाता है।",
            category = Category.ART_CULTURE,
            topic = Topic.DANCE_MUSIC_INSTRUMENTS
        ),
        Question(
            id = 218,
            questionText = "राजस्थान में 'भपंग का जादूगर' किसे कहा जाता है?",
            options = listOf("जहूर खां मेवाती", "कमल साकर खां", "सदीक खां", "पेपे खां"),
            correctAnswerIndex = 0,
            explanation = "जहूर खां मेवाती को 'भपंग का जादूगर', कमल साकर खां को 'कामायचा का बादशाह' तथा सदीक खां को 'खड़ताल का जादूगर' कहा जाता है।",
            category = Category.ART_CULTURE,
            topic = Topic.DANCE_MUSIC_INSTRUMENTS
        ),

        // CUSTOMS & ORNAMENTS
        Question(
            id = 219,
            questionText = "राजस्थान में विवाह के अवसर पर दिया जाने वाला सामूहिक प्रीतिभोज क्या कहलाता है?",
            options = listOf("बढ़ार", "मौसर (जोसर)", "सामेला", "नांगल"),
            correctAnswerIndex = 0,
            explanation = "विवाह के सामूहिक भोज को 'बढ़ार' कहते हैं, नवगृह प्रवेश को 'नांगल' तथा मृत्युभोज को 'मौसर' कहा जाता है।",
            category = Category.ART_CULTURE,
            topic = Topic.CUSTOMS_ORNAMENTS
        ),
        Question(
            id = 220,
            questionText = "आदिवासी समाज में वर पक्ष द्वारा वधू के पिता को कन्या के बदले दिए जाने वाले वधू-मूल्य को क्या कहते हैं?",
            options = listOf("दापा प्रथा", "नातरा प्रथा", "आटा-साटा प्रथा", "हेलमो प्रथा"),
            correctAnswerIndex = 0,
            explanation = "आदिवासियों में वर पक्ष द्वारा वधू के पिता को दिया जाने वाला वधू मूल्य 'दापा' कहलाता है।",
            category = Category.ART_CULTURE,
            topic = Topic.CUSTOMS_ORNAMENTS
        ),
        Question(
            id = 221,
            questionText = "'मेमन्द', 'बोरला', 'शीशफूल', 'रखड़ी' व 'टीडी भलको' शरीर के किस अंग के आभूषण हैं?",
            options = listOf("सिर व मस्तक के आभूषण", "कान के आभूषण", "गले के आभूषण", "हाथ के आभूषण"),
            correctAnswerIndex = 0,
            explanation = "मेमन्द, बोरला, शीशफूल, रखड़ी, गोफण और टीडी भलको स्त्रियों के सिर व मस्तक पर पहने जाने वाले पारंपरिक आभूषण हैं।",
            category = Category.ART_CULTURE,
            topic = Topic.CUSTOMS_ORNAMENTS
        ),
        Question(
            id = 222,
            questionText = "दांत में सोने या चांदी की कील जड़वाना क्या कहलाता है?",
            options = listOf("चूप (या रखन)", "चौंप", "तिमणिया", "बजंटी"),
            correctAnswerIndex = 0,
            explanation = "दांत के प्रमुख आभूषण 'चूप', 'रखन', 'धांस' और 'मेख' हैं। ध्यान दें: 'चौंप' नाक का आभूषण है, जबकि 'चूप' दांत का आभूषण है।",
            category = Category.ART_CULTURE,
            topic = Topic.CUSTOMS_ORNAMENTS
        ),
        Question(
            id = 223,
            questionText = "महिलाओं द्वारा गले में पहना जाने वाला 'तिमणिया', 'मांदलिया' व 'हांसली' किस अंग का आभूषण है?",
            options = listOf("गला", "कमर", "पैर", "बाजू"),
            correctAnswerIndex = 0,
            explanation = "तिमणिया, मांदलिया, हांसली, बजंटी, तुलसी, ठुस्सी, आड व चंपाकली गले के आभूषण हैं।",
            category = Category.ART_CULTURE,
            topic = Topic.CUSTOMS_ORNAMENTS
        ),

        // FAIRS & FESTIVALS
        Question(
            id = 224,
            questionText = "राजस्थान का प्रसिद्ध 'बेणेश्वर धाम मेला' (आदिवासियों का कुंभ) किन नदियों के त्रिवेणी संगम पर और किस तिथि को भरता है?",
            options = listOf("सोम, माही, जाखम संगम पर - माघ पूर्णिमा", "बनास, बेड़च, मेनाल संगम पर - कार्तिक पूर्णिमा", "चम्बल, बनास, सीप संगम पर - चैत्र पूर्णिमा", "कालीसिंध व आहू संगम पर - वैशाख पूर्णिमा"),
            correctAnswerIndex = 0,
            explanation = "बेणेश्वर मेला (नवाटापरा, डूंगरपुर) सोम, माही व जाखम के संगम पर माघ पूर्णिमा को भरता है। यहां खंडित शिवलिंग की पूजा की जाती है।",
            category = Category.ART_CULTURE,
            topic = Topic.FAIRS_FESTIVALS
        ),
        Question(
            id = 225,
            questionText = "प्रसिद्ध 'पुष्कर मेला' किस तिथि को आयोजित होता है जो राजस्थान का सबसे रंगीन और विदेशी पर्यटकों का प्रिय मेला है?",
            options = listOf("कार्तिक पूर्णिमा", "माघ पूर्णिमा", "श्रावण पूर्णिमा", "फाल्गुन पूर्णिमा"),
            correctAnswerIndex = 0,
            explanation = "पुष्कर मेला (अजमेर) कार्तिक पूर्णिमा को आयोजित होता है। इसे मेरवाड़ा का कुंभ और राजस्थान का सबसे रंगीन मेला कहा जाता है।",
            category = Category.ART_CULTURE,
            topic = Topic.FAIRS_FESTIVALS
        ),
        Question(
            id = 226,
            questionText = "राजस्थान में प्रसिद्ध 'लठ्ठमार होली' और 'कोड़ामार होली' क्रमशः कहां खेली जाती है?",
            options = listOf("श्री महावीर जी (करौली) और भिनाय (अजमेर/केकड़ी)", "ब्यावर और बाड़मेर", "नाथद्वारा और जयपुर", "सांगोद और डूंगरपुर"),
            correctAnswerIndex = 0,
            explanation = "लठ्ठमार होली श्री महावीर जी (करौली), कोड़ामार होली भिनाय, पत्थरमार होली बाड़मेर और अंगारों की होली केकड़ी में खेली जाती है।",
            category = Category.ART_CULTURE,
            topic = Topic.FAIRS_FESTIVALS
        ),
        Question(
            id = 227,
            questionText = "'कजली तीज' (बड़ी तीज / सातुड़ी तीज) का प्रसिद्ध मेला एवं सवारी किस जिले की विख्यात है?",
            options = listOf("बूंदी (भाद्रपद कृष्ण तृतीया)", "जयपुर (श्रावण शुक्ल तृतीया)", "उदयपुर", "जोधपुर"),
            correctAnswerIndex = 0,
            explanation = "बड़ी तीज/कजली तीज की भव्य सवारी बूंदी में भाद्रपद कृष्ण तृतीया को निकाली जाती है, जबकि छोटी तीज की सवारी जयपुर की प्रसिद्ध है (श्रावण शुक्ल तृतीया)।",
            category = Category.ART_CULTURE,
            topic = Topic.FAIRS_FESTIVALS
        ),

        // FORTS, CHHATRIS & ARCHITECTURE
        Question(
            id = 228,
            questionText = "अबुल फजल ने किस दुर्ग के बारे में लिखा था कि 'यह दुर्ग इतनी बुलंदी पर बना है कि नीचे से ऊपर देखने पर सिर की पगड़ी गिर जाती है'?",
            options = listOf("कटारगढ़ / कुम्भलगढ़ दुर्ग", "चित्तौड़गढ़ दुर्ग", "मेहरानगढ़ दुर्ग", "रणथम्भौर दुर्ग"),
            correctAnswerIndex = 0,
            explanation = "अबुल फजल ने कुम्भलगढ़ के अंतःदुर्ग 'कटारगढ़' (मेवाड़ की आंख) की ऊंचाई देखकर कहा था कि नीचे से ऊपर देखने पर सिर की पगड़ी गिर जाती है।",
            category = Category.ART_CULTURE,
            topic = Topic.FORTS_HAVELIS_CHHATRIS
        ),
        Question(
            id = 229,
            questionText = "बूंदी के तारागढ़ दुर्ग में स्थित कौन-सी तोप अपनी भीषण गर्जना के लिए 'गर्भगुंजन' कहलाती है?",
            options = listOf("गर्भगुंजन तोप", "किलकिला तोप", "शम्भूबाण तोप", "जयबाण तोप"),
            correctAnswerIndex = 0,
            explanation = "बूंदी के किले की प्रसिद्ध तोप 'गर्भगुंजन' है, जबकि मेहरानगढ़ (जोधपुर) में किलकिला, शम्भूबाण, गजनी खां और कड़क बिजली तोपें हैं। जयगढ़ दुर्ग में एशिया की सबसे बड़ी 'जयबाण तोप' है।",
            category = Category.ART_CULTURE,
            topic = Topic.FORTS_HAVELIS_CHHATRIS
        ),
        Question(
            id = 230,
            questionText = "राजस्थान में भगवान शिव को समर्पित '84 खंभों की छतरी' किस जिले में स्थित है?",
            options = listOf("बूंदी", "अलवर", "मांडलगढ़ (भीलवाड़ा)", "रणथम्भौर"),
            correctAnswerIndex = 0,
            explanation = "84 खंभों की छतरी बूंदी में स्थित है। अलवर में मूसी महारानी की '80 खंभों की छतरी' है और रणथम्भौर व मांडलगढ़ में '32 खंभों की छतरी' स्थित है।",
            category = Category.ART_CULTURE,
            topic = Topic.FORTS_HAVELIS_CHHATRIS
        ),
        Question(
            id = 231,
            questionText = "सफेद संगमरमर से निर्मित जोधपुर का 'जसवंत थड़ा' किस उपनाम से जाना जाता है?",
            options = listOf("राजस्थान का ताजमहल", "हाड़ौती का ताजमहल", "कांठल का ताजमहल", "वस्त्र ताजमहल"),
            correctAnswerIndex = 0,
            explanation = "जोधपुर स्थित जसवंत थड़ा को 'राजस्थान का ताजमहल' कहा जाता है। कोटा के अबली-मीणी महल को 'हाड़ौती का ताजमहल' तथा काकाजी दरगाह (प्रतापगढ़) को 'कांठल का ताजमहल' कहते हैं।",
            category = Category.ART_CULTURE,
            topic = Topic.FORTS_HAVELIS_CHHATRIS
        ),
        Question(
            id = 232,
            questionText = "जयपुर के हवामहल (1799 ई., सवाई प्रतापसिंह निर्मित) की पांचों मंजिलों का नीचे से ऊपर सही क्रम क्या है?",
            options = listOf("शरद मंदिर, रत्न मंदिर, विचित्र मंदिर, प्रकाश मंदिर, हवा मंदिर", "हवा मंदिर, प्रकाश मंदिर, विचित्र मंदिर, रत्न मंदिर, शरद मंदिर", "रत्न मंदिर, शरद मंदिर, विचित्र मंदिर, हवा मंदिर, प्रकाश मंदिर", "प्रकाश मंदिर, शरद मंदिर, हवा मंदिर, रत्न मंदिर, विचित्र मंदिर"),
            correctAnswerIndex = 0,
            explanation = "हवामहल के 5 तल हैं: पहली मंजिल शरद मंदिर (प्रताप मंदिर), दूसरी रत्न मंदिर, तीसरी विचित्र मंदिर, चौथी प्रकाश मंदिर तथा पांचवीं हवा मंदिर। इसमें कुल 953 खिड़कियां हैं।",
            category = Category.ART_CULTURE,
            topic = Topic.FORTS_HAVELIS_CHHATRIS
        ),

        // PAINTINGS & HANDICRAFTS
        Question(
            id = 233,
            questionText = "किशनगढ़ चित्रकला शैली की अमर कृति 'बणी-ठणी' के चित्रकार कौन थे जिसे एरिक डिक्सन ने 'भारत की मोनालिसा' कहा?",
            options = listOf("मोरध्वज निहालचंद", "साहिबदीन", "मनोहर", "हीरानंद"),
            correctAnswerIndex = 0,
            explanation = "बणी-ठणी सावंतसिंह (नागरीदास) की प्रेयसी थी। इसका चित्रण मोरध्वज निहालचंद ने किया। 1973 में इस पर 20 पैसे का डाक टिकट जारी हुआ था।",
            category = Category.ART_CULTURE,
            topic = Topic.PAINTINGS_HANDICRAFTS
        ),
        Question(
            id = 234,
            questionText = "बेल्जियम के रंगीन कांच पर सोने की अत्यंत बारीक मीनाकारी करने वाली विश्वविख्यात 'थेवाकला' किस जिले की पहचान है?",
            options = listOf("प्रतापगढ़ (राजसोनी परिवार)", "जयपुर", "बाड़मेर", "बीकानेर"),
            correctAnswerIndex = 0,
            explanation = "थेवाकला प्रतापगढ़ की प्रसिद्ध हस्तकला है। नाथूजी सोनी इसके आदि प्रवर्तक थे। महेश राज सोनी को 2015 में इसके लिए पद्मश्री पुरस्कार मिला था।",
            category = Category.ART_CULTURE,
            topic = Topic.PAINTINGS_HANDICRAFTS
        ),
        Question(
            id = 235,
            questionText = "अजरक प्रिंट और मलीर प्रिंट राजस्थान के किस क्षेत्र के प्रसिद्ध वस्त्र अलंकरण हैं?",
            options = listOf("बाड़मेर", "सांगानेर (जयपुर)", "अकोला (चित्तौड़गढ़)", "बगरू"),
            correctAnswerIndex = 0,
            explanation = "अजरक प्रिंट (नीला व लाल रंग, दोनों तरफ छपाई) और मलीर प्रिंट (कत्थई व काला) बाड़मेर के विश्वप्रसिद्ध हस्तशिल्प हैं।",
            category = Category.ART_CULTURE,
            topic = Topic.PAINTINGS_HANDICRAFTS
        ),
        Question(
            id = 236,
            questionText = "राजस्थान का सबसे प्राचीन लोकनाट्य जिसे 'लोकनाट्यों का मेरुनाट्य' कहा जाता है, कौन-सा है?",
            options = listOf("गवरी (राई लोकनाट्य - भीलों द्वारा)", "ख्याल", "तमाशा", "रम्मत"),
            correctAnswerIndex = 0,
            explanation = "गवरी मेवाड़ के भीलों द्वारा सावन-भादो में 40 दिनों तक दिन में मंचित किया जाने वाला भारत का सबसे प्राचीन लोकनाट्य है, जिसका कथानक शिव-भस्मासुर कथा पर आधारित है।",
            category = Category.ART_CULTURE,
            topic = Topic.DANCE_MUSIC_INSTRUMENTS
        )
    )
}
