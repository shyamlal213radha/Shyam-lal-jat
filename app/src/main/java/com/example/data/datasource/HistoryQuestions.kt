package com.example.data.datasource

import com.example.data.model.Category
import com.example.data.model.Question
import com.example.data.model.Topic

object HistoryQuestions {
    val list: List<Question> = listOf(
        // ARCHAEOLOGY & EXCAVATORS
        Question(
            id = 101,
            questionText = "कालीबंगा सभ्यता स्थल (हनुमानगढ़) की खोज और उत्खनन कार्य से कौन संबंधित हैं?",
            options = listOf("अमलानन्द घोष, बी.बी. लाल व बी.के. थापर", "दयाराम साहनी व नील रत्न बनर्जी", "आर.सी. अग्रवाल व वी.एन. मिश्र", "सी.ए. हैकर व सेटनकार"),
            correctAnswerIndex = 0,
            explanation = "कालीबंगा की खोज 1952 में अमलानन्द घोष ने की तथा 1961-62 में बी.बी. लाल व बी.के. थापर द्वारा उत्खनन करवाया गया (घग्घर नदी तट)।",
            category = Category.HISTORY,
            topic = Topic.ARCHAEOLOGY_INSCRIPTIONS
        ),
        Question(
            id = 102,
            questionText = "बागौर सभ्यता स्थल (भीलवाड़ा) किस नदी के किनारे स्थित है तथा इसका उत्खनन किसने किया?",
            options = listOf("कोठारी नदी - वी.एन. मिश्र एवं एल.एस. लैशानि", "आयड़ नदी - अक्षय कीर्ति व्यास", "बाणगंगा - दयाराम साहनी", "कांटली नदी - रतनचन्द्र अग्रवाल"),
            correctAnswerIndex = 0,
            explanation = "बागौर भीलवाड़ा में कोठारी नदी के किनारे स्थित है, जिसका उत्खनन 1967-68 में वी.एन. मिश्र व एल.एस. लैशानि द्वारा किया गया।",
            category = Category.HISTORY,
            topic = Topic.ARCHAEOLOGY_INSCRIPTIONS
        ),
        Question(
            id = 103,
            questionText = "गणेश्वर (सीकर) सभ्यता स्थल का उत्खनन 1977 ई. में किसके द्वारा किया गया?",
            options = listOf("रतनचन्द्र अग्रवाल व विजय कुमार", "अक्षय कीर्ति व्यास", "बी.बी. लाल", "के.वी. सौन्दराजन"),
            correctAnswerIndex = 0,
            explanation = "गणेश्वर (सीकर) में कांतली नदी तट पर 1977 ई. में रतनचन्द्र अग्रवाल व विजय कुमार द्वारा उत्खनन किया गया। इसे ताम्रयुगीन सभ्यताओं की जननी कहा जाता है।",
            category = Category.HISTORY,
            topic = Topic.ARCHAEOLOGY_INSCRIPTIONS
        ),
        Question(
            id = 104,
            questionText = "अशोक के भाब्रू शिलालेख की खोज 1837 ई. में बैराठ में किसने की थी?",
            options = listOf("कैप्टन बर्ट", "कार्लाइल", "कर्नल जेम्स टॉड", "अलेक्जेंडर कनिंघम"),
            correctAnswerIndex = 0,
            explanation = "बैराठ (कोटपूतली-बहरोड़) में 1837 ई. में कैप्टन बर्ट ने बीजक की पहाड़ी से अशोक का भाब्रू शिलालेख खोजा था।",
            category = Category.HISTORY,
            topic = Topic.ARCHAEOLOGY_INSCRIPTIONS
        ),
        Question(
            id = 105,
            questionText = "राजस्थान में ताम्रवती नगरी के नाम से प्रसिद्ध 'आहड़' सभ्यता का उत्खनन सर्वप्रथम 1953 ई. में किसने किया?",
            options = listOf("अक्षय कीर्ति व्यास", "अमलानन्द घोष", "कैलाशनाथ दीक्षित", "दयाराम साहनी"),
            correctAnswerIndex = 0,
            explanation = "आहड़ (उदयपुर) का उत्खनन 1953 ई. में अक्षय कीर्ति व्यास, 1954 में आर.सी. अग्रवाल तथा 1961-62 में वी.एन. मिश्र व एच.डी. सांकलिया द्वारा किया गया।",
            category = Category.HISTORY,
            topic = Topic.ARCHAEOLOGY_INSCRIPTIONS
        ),
        Question(
            id = 106,
            questionText = "भीलवाड़ा का बिजौलिया शिलालेख (1170 ई.) किस शासक के काल का है?",
            options = listOf("सोमेश्वर चौहान", "पृथ्वीराज तृतीय", "विग्रहराज चतुर्थ", "अर्णोराज"),
            correctAnswerIndex = 0,
            explanation = "बिजौलिया शिलालेख 1170 ई. में सोमेश्वर चौहान के काल का है। इसमें चौहानों को 'वत्सगोत्रीय ब्राह्मण' बताया गया है।",
            category = Category.HISTORY,
            topic = Topic.ARCHAEOLOGY_INSCRIPTIONS
        ),
        Question(
            id = 107,
            questionText = "किस अभिलेख में कछवाहों को 'रघुकुल तिलक' कहा गया है?",
            options = listOf("आमेर प्रशस्ति (1612 ई.)", "सामोली शिलालेख", "बिजौलिया शिलालेख", "एकलिंग प्रशस्ति"),
            correctAnswerIndex = 0,
            explanation = "जयपुर की आमेर प्रशस्ति (1612 ई.) में पृथ्वीराज से मानसिंह तक का वर्णन है और कछवाहों को 'रघुकुल तिलक' कहा गया है।",
            category = Category.HISTORY,
            topic = Topic.ARCHAEOLOGY_INSCRIPTIONS
        ),
        Question(
            id = 108,
            questionText = "मेवाड़ की प्रसिद्ध 'एकलिंग प्रशस्ति' (1488 ई.) के रचयिता कौन थे?",
            options = listOf("महेश भट्ट", "आम्रकवि", "जीजा", "कान्हा व्यास"),
            correctAnswerIndex = 0,
            explanation = "एकलिंग प्रशस्ति के रचयिता महेश भट्ट थे। इसमें बापा रावल का संन्यास लेना एवं मेवाड़ के गुहिलों का वर्णन है।",
            category = Category.HISTORY,
            topic = Topic.ARCHAEOLOGY_INSCRIPTIONS
        ),
        Question(
            id = 109,
            questionText = "परमारों की उत्पत्ति गुरु वशिष्ठ के आबू यज्ञ से बताने वाला अभिलेख कौन-सा है?",
            options = listOf("किराडू लेख (1161 ई., बाड़मेर)", "नाथ प्रशस्ति", "अपराजित का लेख", "चाटसू अभिलेख"),
            correctAnswerIndex = 0,
            explanation = "बाड़मेर के किराडू लेख (1161 ई.) में परमारों की उत्पत्ति गुरु वशिष्ठ के आबू यज्ञ से बताई गई है तथा परमारों का वंशक्रम दिया गया है।",
            category = Category.HISTORY,
            topic = Topic.ARCHAEOLOGY_INSCRIPTIONS
        ),

        // COINS & STATES
        Question(
            id = 110,
            questionText = "रियासतकालीन 'झाड़शाही', 'मुहम्मदशाही' व 'हाली' सिक्के किस राज्य में प्रचलित थे?",
            options = listOf("जयपुर राज्य", "जोधपुर राज्य", "मेवाड़ राज्य", "कोटा राज्य"),
            correctAnswerIndex = 0,
            explanation = "जयपुर राज्य में झाड़शाही, मुहम्मदशाही, हाली और माधोशाही रुपया प्रचलन में थे।",
            category = Category.HISTORY,
            topic = Topic.DYNASTIES_RULERS
        ),
        Question(
            id = 111,
            questionText = "'तमंचाशाही' सिक्का राजस्थान की किस रियासत में चलता था?",
            options = listOf("धौलपुर राज्य", "अलवर राज्य", "करौली राज्य", "टोंक राज्य"),
            correctAnswerIndex = 0,
            explanation = "धौलपुर राज्य का प्रमुख रियासती सिक्का 'तमंचाशाही' था।",
            category = Category.HISTORY,
            topic = Topic.DYNASTIES_RULERS
        ),
        Question(
            id = 112,
            questionText = "मेवाड़ रियासत में प्रचलित प्रमुख तांबे व चांदी के सिक्के कौन-से थे?",
            options = listOf("दींगला, एलची, चितौड़ी, त्रिशूलिया व स्वरूपशाही", "विजयशाही व गधिया सिक्के", "अखयशाही व डोडिया", "चांदोड़ी व मदनशाही"),
            correctAnswerIndex = 0,
            explanation = "मेवाड़ राज्य में दींगला, सिक्का एलची, चितौड़ी, भीलाड़ी, उदयपुरी, चांदोड़ी, स्वरूपशाही, फतहशाही व भोपाली प्रचलित थे।",
            category = Category.HISTORY,
            topic = Topic.DYNASTIES_RULERS
        ),
        Question(
            id = 113,
            questionText = "जैसलमेर रियासत में तांबे का कौन-सा सिक्का चलता था?",
            options = listOf("डोडिया", "दींगला", "तमंचाशाही", "डब्बूशाही"),
            correctAnswerIndex = 0,
            explanation = "जैसलमेर राज्य में अखयशाही, मुहम्मदशाही और तांबे का 'डोडिया' सिक्का चलता था।",
            category = Category.HISTORY,
            topic = Topic.DYNASTIES_RULERS
        ),

        // DYNASTIES & FOUNDERS & GENERALS
        Question(
            id = 114,
            questionText = "मारवाड़ के राठौड़ वंश के संस्थापक व मूल पुरुष कौन थे?",
            options = listOf("राव सीहा", "राव जोधा", "राव बीका", "राव मालदेव"),
            correctAnswerIndex = 0,
            explanation = "राव सीहा (1240–1273 ई.) मारवाड़ के राठौड़ वंश के संस्थापक, मूल पुरुष और आदि पुरुष माने जाते हैं।",
            category = Category.HISTORY,
            topic = Topic.DYNASTIES_RULERS
        ),
        Question(
            id = 115,
            questionText = "जालौर के चौहान वंश का संस्थापक किसे माना जाता है?",
            options = listOf("कीर्तिपाल चौहान (1181 ई.)", "गोविन्दराज चौहान", "अजयराज चौहान", "लक्ष्मण चौहान"),
            correctAnswerIndex = 0,
            explanation = "जालौर में चौहान वंश की स्थापना 1181 ई. में कीर्तिपाल चौहान ने की थी (नाडोल के लक्ष्मण चौहान के वंशज)।",
            category = Category.HISTORY,
            topic = Topic.DYNASTIES_RULERS
        ),
        Question(
            id = 116,
            questionText = "मारवाड़ शासक मालदेव के प्रसिद्ध वीर सेनापति कौन थे जो गिरी-सुमेल युद्ध में लड़े?",
            options = listOf("जैता और कूंपा", "गोरा और बादल", "जयमल और फता", "आल्हा और ऊदल"),
            correctAnswerIndex = 0,
            explanation = "मालदेव के प्रमुख सेनापति जैता और कूंपा थे, जिनकी वीरता देखकर शेरशाह सूरी ने कहा था 'मुट्ठी भर बाजरे के लिए हिन्दुस्तान की बादशाहत खो देता।' ",
            category = Category.HISTORY,
            topic = Topic.DYNASTIES_RULERS
        ),
        Question(
            id = 117,
            questionText = "चित्तौड़ के प्रथम साके (1303 ई.) में रावल रतनसिंह की ओर से वीरतापूर्वक लड़ने वाले सेनापति कौन थे?",
            options = listOf("गोरा और बादल", "जयमल और फता", "जैता और कूंपा", "रणमल और रतिपाल"),
            correctAnswerIndex = 0,
            explanation = "1303 ई. में अलाउद्दीन खिलजी के आक्रमण के समय रावल रतनसिंह के सेनापति गोरा और बादल ने अद्भुत पराक्रम दिखाया।",
            category = Category.HISTORY,
            topic = Topic.DYNASTIES_RULERS
        ),
        Question(
            id = 118,
            questionText = "रणथम्भौर के हम्मीर देव चौहान के कौन-से दो सेनापतियों ने अलाउद्दीन से विश्वासघात किया था?",
            options = listOf("रणमल और रतिपाल", "जैता और कूंपा", "गोरा और बादल", "बालक और मदन"),
            correctAnswerIndex = 0,
            explanation = "रणथम्भौर के युद्ध (1301 ई.) में हम्मीर देव के सेनापति रणमल और रतिपाल ने विश्वासघात किया था।",
            category = Category.HISTORY,
            topic = Topic.DYNASTIES_RULERS
        ),

        // HISTORICAL BATTLES
        Question(
            id = 119,
            questionText = "तराइन का प्रथम युद्ध (1191 ई.) में किसकी विजय हुई थी?",
            options = listOf("पृथ्वीराज चौहान तृतीय", "मुहम्मद गौरी", "कुतुबुद्दीन ऐबक", "जयचन्द गहड़वाल"),
            correctAnswerIndex = 0,
            explanation = "तराइन के प्रथम युद्ध (1191 ई., करनाल) में पृथ्वीराज चौहान तृतीय ने मुहम्मद गौरी को पराजित किया था।",
            category = Category.HISTORY,
            topic = Topic.BATTLES_JOHAR
        ),
        Question(
            id = 120,
            questionText = "सारंगपुर का युद्ध (1437 ई.) किनके मध्य हुआ और इसकी विजय के उपलक्ष्य में क्या बनवाया गया?",
            options = listOf("महाराणा कुम्भा व महमूद खिलजी प्रथम - विजय स्तम्भ", "राणा सांगा व इब्राहिम लोदी - कीर्ति स्तम्भ", "हम्मीर व अलाउद्दीन खिलजी - त्रिनेत्र मंदिर", "महाराणा प्रताप व अकबर - कुम्भलगढ़ दुर्ग"),
            correctAnswerIndex = 0,
            explanation = "1437 ई. में महाराणा कुम्भा ने मालवा के सुल्तान महमूद खिलजी प्रथम को पराजित किया और इस विजय की स्मृति में चित्तौड़गढ़ में 'विजय स्तम्भ' बनवाया।",
            category = Category.HISTORY,
            topic = Topic.BATTLES_JOHAR
        ),
        Question(
            id = 121,
            questionText = "खानवा का प्रसिद्ध युद्ध कब और किनके बीच लड़ा गया था?",
            options = listOf("17 मार्च, 1527 ई. - बाबर और राणा सांगा", "16 फरवरी, 1527 ई. - बाबर और हसन खां मेवाती", "5 जनवरी, 1544 ई. - मालदेव और शेरशाह", "18 जून, 1576 ई. - प्रताप और मानसिंह"),
            correctAnswerIndex = 0,
            explanation = "खानवा (भरतपुर) का युद्ध 17 मार्च, 1527 ई. को बाबर और राणा सांगा के मध्य हुआ जिसमें बाबर विजयी रहा और उसने 'गाजी' की उपाधि धारण की।",
            category = Category.HISTORY,
            topic = Topic.BATTLES_JOHAR
        ),
        Question(
            id = 122,
            questionText = "गिरी-सुमेल का युद्ध (5 जनवरी, 1544 ई.) किनके मध्य लड़ा गया?",
            options = listOf("मारवाड़ शासक मालदेव व शेरशाह सूरी", "राणा सांगा व बाबर", "महाराणा प्रताप व अकबर", "राव जैतसी व मालदेव"),
            correctAnswerIndex = 0,
            explanation = "गिरी-सुमेल (पाली) का युद्ध 5 जनवरी, 1544 ई. को मालदेव की सेना (जैता-कूंपा) और शेरशाह सूरी के बीच हुआ, जिसमें शेरशाह विजयी रहा।",
            category = Category.HISTORY,
            topic = Topic.BATTLES_JOHAR
        ),
        Question(
            id = 123,
            questionText = "हल्दीघाटी युद्ध (1576 ई.) को कर्नल जेम्स टॉड ने किस नाम से पुकारा है?",
            options = listOf("मेवाड़ की थर्मोपॉली", "मेवाड़ का मैराथन", "गोगुन्दा का युद्ध", "खमनौर का युद्ध"),
            correctAnswerIndex = 0,
            explanation = "कर्नल जेम्स टॉड ने हल्दीघाटी युद्ध को 'मेवाड़ की थर्मोपॉली' कहा, जबकि दिवेर युद्ध (1582 ई.) को 'मेवाड़ का मैराथन' कहा।",
            category = Category.HISTORY,
            topic = Topic.BATTLES_JOHAR
        ),
        Question(
            id = 124,
            questionText = "अकबर के इतिहासकार बदायूंनी ने हल्दीघाटी युद्ध को क्या नाम दिया?",
            options = listOf("गोगुन्दा का युद्ध", "खमनौर का युद्ध", "अनिर्णायक युद्ध", "जिहाद का युद्ध"),
            correctAnswerIndex = 0,
            explanation = "बदायूंनी ने इसे 'गोगुन्दा का युद्ध' कहा, अबुल फजल ने इसे 'खमनौर का युद्ध' कहा और गोपीनाथ शर्मा ने 'अनिर्णायक युद्ध' कहा।",
            category = Category.HISTORY,
            topic = Topic.BATTLES_JOHAR
        ),
        Question(
            id = 125,
            questionText = "'मतीरे की राड़' का ऐतिहासिक युद्ध (1644 ई.) किन राजाओं के मध्य हुआ था?",
            options = listOf("अमरसिंह राठौड़ (नागौर) व राजा कर्णसिंह (बीकानेर)", "मालदेव व राव जैतसी", "सवाई जयसिंह व मराठा", "ईश्वरीसिंह व माधोसिंह"),
            correctAnswerIndex = 0,
            explanation = "1644 ई. में मतीरे की बेल की सीमा विवाद को लेकर नागौर के अमरसिंह राठौड़ व बीकानेर के कर्णसिंह के मध्य यह युद्ध हुआ।",
            category = Category.HISTORY,
            topic = Topic.BATTLES_JOHAR
        ),

        // TITLES & RULERS
        Question(
            id = 126,
            questionText = "राजस्थान इतिहास में 'मारवाड़ का प्रताप' और 'भूला-बिसरा राजा' किसे कहा जाता है?",
            options = listOf("राव चन्द्रसेन", "राव मालदेव", "दुर्गादास राठौड़", "मोटा राजा उदयसिंह"),
            correctAnswerIndex = 0,
            explanation = "राव चन्द्रसेन को 'मारवाड़ का प्रताप', 'भूला-बिसरा राजा' व 'महाराणा प्रताप का अग्रगामी' कहा जाता है क्योंकि उन्होंने अकबर की अधीनता स्वीकार नहीं की।",
            category = Category.HISTORY,
            topic = Topic.DYNASTIES_RULERS
        ),
        Question(
            id = 127,
            questionText = "फारसी इतिहासकारों ने किस राजपूत शासक को 'हशमत वाला राजा' कहा है?",
            options = listOf("राव मालदेव", "महाराणा सांगा", "राव जोधा", "राव चन्द्रसेन"),
            correctAnswerIndex = 0,
            explanation = "राव मालदेव (मारवाड़) को 52 युद्धों और 58 परगनों का विजेता होने के कारण 'हशमत वाला राजा' कहा गया है।",
            category = Category.HISTORY,
            topic = Topic.DYNASTIES_RULERS
        ),
        Question(
            id = 128,
            questionText = "बीकानेर के किस शासक को मुंशी देवी प्रसाद ने 'राजपूताने का कर्ण' कहा था?",
            options = listOf("महाराजा रायसिंह", "राव लूणकरण", "राव बीका", "महाराजा गंगासिंह"),
            correctAnswerIndex = 0,
            explanation = "मुंशी देवी प्रसाद ने महाराजा रायसिंह को 'राजपूताने का कर्ण' कहा, जबकि बिठू सूजा ने राव लूणकरण को 'कलयुग का कर्ण' कहा।",
            category = Category.HISTORY,
            topic = Topic.DYNASTIES_RULERS
        ),
        Question(
            id = 129,
            questionText = "औरंगजेब द्वारा बीकानेर के महाराजा अनूपसिंह को कौन-सी उपाधि दी गई थी?",
            options = listOf("माही मरातिब", "जांगलधर बादशाह", "मिर्जाराजा", "सवाई राजा"),
            correctAnswerIndex = 0,
            explanation = "औरंगजेब ने अनूपसिंह को 'माही मरातिब' तथा कर्णसिंह को 'जांगलधर बादशाह' की उपाधि दी थी।",
            category = Category.HISTORY,
            topic = Topic.DYNASTIES_RULERS
        ),
        Question(
            id = 130,
            questionText = "मेवाड़ के महाराणा कुम्भा की प्रमुख उपाधियां कौन-सी हैं?",
            options = listOf("अभिनव भारताचार्य, हिन्दू सुरत्ताण, हालगुरु व चापगुरु", "हिन्दुपत व वन आई साइड मैन", "हशमत वाला राजा", "विषमघाटी पंचानन"),
            correctAnswerIndex = 0,
            explanation = "कुम्भा को अभिनव भारताचार्य, हिन्दू सुरत्ताण, राणो रासो, स्थापत्य कला का जनक, हालगुरु व चापगुरु उपाधियां प्राप्त थीं।",
            category = Category.HISTORY,
            topic = Topic.DYNASTIES_RULERS
        ),

        // 1857 REVOLT
        Question(
            id = 131,
            questionText = "1857 की क्रांति के समय राजस्थान में कुल 6 सैनिक छावनियां थीं, इनमें से किन दो ने विद्रोह में प्रत्यक्ष भाग नहीं लिया?",
            options = listOf("ब्यावर और खैरवाड़ा", "नसीराबाद और देवली", "एरिनपुरा और नीमच", "कोटा और भरतपुर"),
            correctAnswerIndex = 0,
            explanation = "1857 की क्रांति में ब्यावर (मेवाड़ा रेजिमेंट) और खैरवाड़ा (मेवाड़ भील कोर) छावनियों ने प्रत्यक्ष विद्रोह में भाग नहीं लिया था।",
            category = Category.HISTORY,
            topic = Topic.REVOLT_1857
        ),
        Question(
            id = 132,
            questionText = "राजस्थान में 1857 की क्रांति की शुरुआत सर्वप्रथम किस छावनी से और कब हुई?",
            options = listOf("नसीराबाद छावनी - 28 मई 1857", "नीमच छावनी - 3 जून 1857", "एरिनपुरा - 21 अगस्त 1857", "कोटा - 15 अक्टूबर 1857"),
            correctAnswerIndex = 0,
            explanation = "राजस्थान में क्रांति का आरंभ 28 मई 1857 को नसीराबाद छावनी (अजमेर) से 15वीं बंगाल नेटिव इन्फैंट्री (बख्तावर सिंह) द्वारा हुआ।",
            category = Category.HISTORY,
            topic = Topic.REVOLT_1857
        ),
        Question(
            id = 133,
            questionText = "18 सितंबर 1857 को लड़ा गया 'चेलावास का युद्ध' अन्य किस नाम से प्रसिद्ध है?",
            options = listOf("काला-गौरा का युद्ध", "बिथौड़ा का युद्ध", "तुंगा का युद्ध", "हरमाड़ा का युद्ध"),
            correctAnswerIndex = 0,
            explanation = "चेलावास के युद्ध (18 सितम्बर 1857) को 'काला-गौरा का युद्ध' कहा जाता है। इसमें क्रांतिकारियों ने पॉलिटिकल एजेंट मोंक मेसन की हत्या कर उसका सिर आउवा के किले पर लटका दिया था।",
            category = Category.HISTORY,
            topic = Topic.REVOLT_1857
        ),
        Question(
            id = 134,
            questionText = "1857 की क्रांति के समय कोटा रियासत में सुनियोजित विद्रोह का नेतृत्व किसने किया था?",
            options = listOf("जयदयाल और मेहराब खां", "बख्तावर सिंह", "मोहम्मद अली बेग व हीरासिंह", "मोती खां व शीतल प्रसाद"),
            correctAnswerIndex = 0,
            explanation = "कोटा में 15 अक्टूबर 1857 को लाला जयदयाल और रिसालदार मेहराब खां के नेतृत्व में जनविद्रोह हुआ और मेजर बर्टन की हत्या कर दी गई थी।",
            category = Category.HISTORY,
            topic = Topic.REVOLT_1857
        ),

        // PEASANT MOVEMENTS & PRAJAMANDAL
        Question(
            id = 135,
            questionText = "बिजोलिया किसान आंदोलन (1897-1941 ई.) के दूसरे चरण का नेतृत्व 1916 ई. से किसने संभाला?",
            options = listOf("विजय सिंह पथिक", "साधु सीताराम दास", "माणिक्यलाल वर्मा", "रामनारायण चौधरी"),
            correctAnswerIndex = 0,
            explanation = "1916 ई. में विजय सिंह पथिक बिजोलिया किसान आंदोलन से जुड़े और 1917 में उन्होंने 'ऊपरमाल पंच बोर्ड' की स्थापना की।",
            category = Category.HISTORY,
            topic = Topic.PEASANT_PRAJAMANDAL
        ),
        Question(
            id = 136,
            questionText = "रूपाजी और कृपाजी धाकड़ किस किसान आंदोलन के दौरान शहीद हुए थे?",
            options = listOf("बेंगू किसान आंदोलन (1921-1925 ई.)", "बिजोलिया किसान आंदोलन", "अलवर किसान आंदोलन", "बरड़ बूंदी किसान आंदोलन"),
            correctAnswerIndex = 0,
            explanation = "बेंगू किसान आंदोलन में 13 जुलाई 1923 को गोविंदपुरा हत्याकांड में रूपाजी और कृपाजी धाकड़ शहीद हुए थे (ट्रेंच कमीशन इसी से संबंधित है)।",
            category = Category.HISTORY,
            topic = Topic.PEASANT_PRAJAMANDAL
        ),
        Question(
            id = 137,
            questionText = "14 मई 1925 को हुआ 'नीमूचणा हत्याकांड' राजस्थान के किस जिले से संबंधित है जिसे गांधीजी ने 'दोहरी डायरशाही' कहा?",
            options = listOf("अलवर", "भरतपुर", "सीकर", "भीलवाड़ा"),
            correctAnswerIndex = 0,
            explanation = "अलवर रियासत में जंगली सूअरों व कर वृद्धि के विरोध में किसानों की सभा पर गोलियां चलाई गईं, जिसे गांधीजी ने जलियांवाला बाग से भी वीभत्स बताया।",
            category = Category.HISTORY,
            topic = Topic.PEASANT_PRAJAMANDAL
        ),
        Question(
            id = 138,
            questionText = "राजस्थान में उत्तरदायी शासन स्थापित करने वाली पहली रियासत कौन-सी थी?",
            options = listOf("शाहपुरा प्रजामंडल (1938 ई.)", "जयपुर प्रजामंडल", "मेवाड़ प्रजामंडल", "जोधपुर प्रजामंडल"),
            correctAnswerIndex = 0,
            explanation = "शाहपुरा प्रजामंडल (गोकुललाल असावा व मदनलाल पुरोहित) के प्रयासों से शाहपुरा उत्तरदायी शासन स्थापित करने वाली पहली देशी रियासत बनी।",
            category = Category.HISTORY,
            topic = Topic.PEASANT_PRAJAMANDAL
        ),

        // INTEGRATION & PERSONALITIES
        Question(
            id = 139,
            questionText = "राजस्थान के एकीकरण के प्रथम चरण 'मत्स्य संघ' का गठन कब हुआ था?",
            options = listOf("18 मार्च, 1948 ई.", "25 मार्च, 1948 ई.", "18 अप्रैल, 1948 ई.", "30 मार्च, 1949 ई."),
            correctAnswerIndex = 0,
            explanation = "मत्स्य संघ (अलवर, भरतपुर, धौलपुर, करौली + नीमराणा ठिकाना) का निर्माण 18 मार्च, 1948 को हुआ था।",
            category = Category.HISTORY,
            topic = Topic.INTEGRATION_PERSONALITIES
        ),
        Question(
            id = 140,
            questionText = "राजस्थान का वर्तमान स्वरूप (एकीकरण का सातवां चरण) किस तिथि को पूर्ण हुआ?",
            options = listOf("01 नवम्बर, 1956 ई.", "30 मार्च, 1949 ई.", "26 जनवरी, 1950 ई.", "15 मई, 1949 ई."),
            correctAnswerIndex = 0,
            explanation = "01 नवम्बर, 1956 को अजमेर-मेरवाड़ा, आबू-देलवाड़ा तथा सुनेल टप्पा के विलय के साथ राजस्थान का एकीकरण पूर्ण हुआ।",
            category = Category.HISTORY,
            topic = Topic.INTEGRATION_PERSONALITIES
        ),
        Question(
            id = 141,
            questionText = "'वागड़ के गांधी' के नाम से किन्हें जाना जाता है?",
            options = listOf("भोगीलाल पांड्या", "गोकुलभाई भट्ट", "दामोदरलाल व्यास", "प्यारेलाल गुप्ता"),
            correctAnswerIndex = 0,
            explanation = "भोगीलाल पांड्या को 'वागड़ के गांधी', गोकुलभाई भट्ट को 'राजस्थान के गांधी' तथा प्यारेलाल गुप्ता को 'चिड़ावा के गांधी' कहा जाता है।",
            category = Category.HISTORY,
            topic = Topic.INTEGRATION_PERSONALITIES
        ),
        Question(
            id = 142,
            questionText = "राजस्थान के प्रथम राज्यपाल कौन थे?",
            options = listOf("सरदार गुरुमुख निहालसिंह", "महाराजा सवाई मानसिंह", "हीरालाल शास्त्री", "टीकाराम पालीवाल"),
            correctAnswerIndex = 0,
            explanation = "राजस्थान के प्रथम राजप्रमुख महाराजा सवाई मानसिंह थे तथा 1 नवम्बर 1956 को प्रथम राज्यपाल सरदार गुरुमुख निहालसिंह बने।",
            category = Category.HISTORY,
            topic = Topic.INTEGRATION_PERSONALITIES
        ),
        Question(
            id = 143,
            questionText = "राजस्थान का प्रथम द्विभाषी (उर्दू व हिन्दी) समाचार-पत्र 1849 ई. में भरतपुर से कौन-सा प्रकाशित हुआ?",
            options = listOf("मजहरूल सरूर", "राजपूताना अखबार", "सज्जनकीर्ति सुधारक", "नवीन राजस्थान"),
            correctAnswerIndex = 0,
            explanation = "1849 ई. में भरतपुर से प्रकाशित 'मजहरूल सरूर' राजस्थान का प्रथम द्विभाषी (उर्दू व हिन्दी) समाचार-पत्र था।",
            category = Category.HISTORY,
            topic = Topic.INTEGRATION_PERSONALITIES
        ),
        Question(
            id = 144,
            questionText = "जयनारायण व्यास ने 1937 ई. में ब्यावर से राजस्थानी भाषा का प्रथम राजनीतिक पाक्षिक समाचार पत्र कौन-सा निकाला?",
            options = listOf("आगी बाण", "प्रजा सेवक", "तरुण राजस्थान", "त्यागभूमि"),
            correctAnswerIndex = 0,
            explanation = "जयनारायण व्यास ने 1937 में ब्यावर से राजस्थानी भाषा का पहला राजनीतिक पाक्षिक समाचार पत्र 'आगी बाण' प्रकाशित किया था।",
            category = Category.HISTORY,
            topic = Topic.INTEGRATION_PERSONALITIES
        )
    )
}
