package com.example.weather_app_takes2

object CityList {

    val cities = listOf(
        // Cities starting with A
                "Adelaide", "Austin", "Amsterdam", "Athens", "Ankara", "Auckland", "Aspen", "Astana", "Asunción", "Algiers",
                "Aberdeen", "Agra", "Ahmedabad", "Alicante", "Almaty", "Amman", "Anchorage", "Andorra la Vella", "Angkor", "Antwerp",

        // Cities starting with B
                "Berlin", "Beijing", "Barcelona", "Bangkok", "Brisbane", "Budapest", "Buenos Aires", "Brussels", "Baltimore", "Baku",
                "Bamako", "Bandung", "Bangalore", "Banjul", "Barbados", "Barranquilla", "Basel", "Baton Rouge", "Beirut", "Belfast",

        // Cities starting with C
                "Cairo", "Canberra", "Cape Town", "Caracas", "Cardiff", "Casablanca", "Chandigarh", "Charleston", "Charlotte", "Chennai",
                "Chicago", "Chittagong", "Christchurch", "Cincinnati", "Cleveland", "Colombo", "Colorado Springs", "Columbus", "Copenhagen", "Cordoba",

        // Cities starting with D
                "Dakar", "Dallas", "Damascus", "Dar es Salaam", "Davao City", "Delhi", "Denver", "Detroit", "Dhaka", "Doha",
                "Dubai", "Dublin", "Durban", "Durham", "Dushanbe", "Dresden", "Dalian", "Dundee", "Dunedin", "Dortmund",

        // Cities starting with E
                "Ebetsu", "Edinburgh", "Edmonton", "El Paso", "El Aaiún", "Eldoret", "Erbil", "Eindhoven", "Erie", "Eskisehir",
                "Esperance", "Essen", "Eugene", "Evansville", "Exeter", "Eureka", "Everett", "Exmouth", "Eilat", "El Monte",

        // Cities starting with F
                "Fairbanks", "Faisalabad", "Fargo", "Fayetteville", "Fez", "Flagstaff", "Flint", "Florence", "Fortaleza", "Fort Collins",
                "Fort Worth", "Frankfurt", "Fremont", "Fresno", "Fukuoka", "Fuzhou", "Fairfield", "Falkirk", "Falmouth", "Fujairah",

        // Cities starting with G
                "Gabes", "Gaborone", "Galway", "Gangtok", "Gaza", "Gdansk", "Geneva", "Genoa", "Georgetown", "Geraldton",
                "Ghent", "Gibraltar", "Gifu", "Gilbert", "Giza", "Glasgow", "Gold Coast", "Gothenburg", "Granada", "Grand Rapids",

        // Cities starting with H
                "Haifa", "Hakodate", "Halifax", "Hamburg", "Hamilton", "Hamamatsu", "Hanoi", "Hanover", "Harare", "Harbin",
                "Harrisburg", "Hartford", "Havana", "Havre", "Hayward", "Heidelberg", "Helsinki", "Henderson", "Hermosillo", "Hiroshima",

        // Cities starting with I
                "Ibadan", "Ibague", "Ibaraki", "Ibiza", "Iceland", "Ichinomiya", "Idaho Falls", "Ifni", "Iguala", "Ijui",
                "Ilheus", "Iloilo", "Imphal", "Incheon", "Indore", "Innsbruck", "Ipoh", "Ipswich", "Iquique", "Irkutsk",

        // Cities starting with J
                "Jackson", "Jacksonville", "Jaipur", "Jakarta", "Jalalabad", "Jamestown", "Jamnagar", "Jeddah", "Jefferson City", "Jersey City",
                "Jerusalem", "Jhansi", "Jilin", "Jinan", "Jodhpur", "Johannesburg", "Johor Bahru", "Joinville", "Joliet", "Juba",

        // Cities starting with K
                "Kabul", "Kaduna", "Kagoshima", "Kahului", "Kailua", "Kaiserslautern", "Kalamazoo", "Kaliningrad", "Kanazawa", "Kandahar",
                "Kandy", "Kanpur", "Kansas City", "Kaohsiung", "Karachi", "Karaganda", "Karamay", "Karlsruhe", "Kathmandu", "Kawasaki",

        // Cities starting with L
                "La Paz", "Lahore", "Lakewood", "Lancaster", "Lansing", "Laredo", "Las Vegas", "Launceston", "Leeds", "Leicester",
                "Leipzig", "Lhasa", "Liberia", "Libreville", "Lille", "Lima", "Lisbon", "Liverpool", "Ljubljana", "Lome",

        // Cities starting with M
                "Macao", "Maceio", "Macon", "Madison", "Madrid", "Magadan", "Maiduguri", "Mainz", "Majuro", "Makassar",
                "Malabo", "Malaga", "Malang", "Malmo", "Managua", "Manama", "Manaus", "Manchester", "Mandalay", "Manila",

        // Cities starting with N
                "Nagasaki", "Nagoya", "Nairobi", "Nanjing", "Nantes", "Naples", "Nashville", "Nassau", "Natal", "Ndjamena",
                "Nebraska City", "Nelson", "Nepalganj", "New Delhi", "New Haven", "New Orleans", "New York", "Newark", "Newcastle", "Niamey",

        // Cities starting with O
                "Oakland", "Oaxaca", "Odense", "Odessa", "Ogden", "Okayama", "Oklahoma City", "Olympia", "Omaha", "Omsk",
                "Oran", "Oranjestad", "Orlando", "Osaka", "Oslo", "Ostrava", "Ottawa", "Ouagadougou", "Oulu", "Oxford",

        // Cities starting with P
                "Padang", "Pago Pago", "Palembang", "Palermo", "Palm Springs", "Palma", "Panama City", "Papeete", "Paramaribo", "Paris",
                "Patna", "Pattaya", "Pau", "Pecs", "Pekanbaru", "Pensacola", "Pereira", "Perth", "Peshawar", "Philadelphia",

        // Cities starting with Q
                "Qingdao", "Qom", "Quebec City", "Queenstown", "Queretaro", "Quetta", "Quimper", "Quito", "Quzhou", "Qyzylorda",
                "Qena", "Qingyuan", "Qinhuangdao", "Qiqihar", "Qom", "Queanbeyan", "Queenborough", "Queens", "Quilmes", "Quispamsis",

        // Cities starting with R
                "Rabat", "Rajkot", "Raleigh", "Rampur", "Rancho Cucamonga", "Rangoon", "Rapid City", "Ras Al Khaimah", "Reading", "Recife",
                "Regina", "Reims", "Rennes", "Reno", "Reykjavik", "Richmond", "Riga", "Rio de Janeiro", "Riyadh", "Roanoke",

        // Cities starting with S
                "Sacramento", "Saginaw", "Saharanpur", "Saint Petersburg", "Salem", "Salinas", "Salta", "Saltillo", "Salvador", "Salzburg",
                "Samara", "San Antonio", "San Bernardino", "San Diego", "San Francisco", "San Jose", "San Juan", "San Luis Potosi", "San Salvador", "Santa Cruz",

        // Cities starting with T
                "Tabriz", "Tacoma", "Taipei", "Taiyuan", "Tallinn", "Tampa", "Tangier", "Tashkent", "Tbilisi", "Tegucigalpa",
                "Tehran", "Tel Aviv", "Tempe", "Teresina", "Thessaloniki", "Thimphu", "Tianjin", "Tijuana", "Tirana", "Tokyo",

        // Cities starting with U
                "Ulaanbaatar", "Ulyanovsk", "Utrecht", "Uberlandia", "Udine", "Ufa", "Ujjain", "Ulan-Ude", "Ulhasnagar", "Ulyanovsk",
                "Uppsala", "Urasoe", "Urdaneta", "Urgench", "Uruapan", "Urumqi", "Ushuaia", "Usinsk", "Usti nad Labem", "Utrecht",

        // Cities starting with V
                "Valencia", "Valparaiso", "Vancouver", "Varna", "Venice", "Veracruz", "Verona", "Vientiane", "Vienna", "Vijayawada",
                "Vilnius", "Vinh", "Visakhapatnam", "Vitebsk", "Vitoria", "Vladikavkaz", "Vladimir", "Vladivostok", "Volgograd", "Voronezh",

        // Cities starting with W
                "Waco", "Wakayama", "Warangal", "Washington, D.C.", "Wellington", "Wenzhou", "West Palm Beach", "Wichita", "Wiesbaden", "Winnipeg",
                "Winston-Salem", "Wollongong", "Worcester", "Wroclaw", "Wuhan", "Wuhu", "Wuppertal", "Wuxi", "Wuzhou", "Wyoming",

        // Cities starting with X
                "Xalapa", "Xiamen", "Xian", "Xiangfan", "Xingtai", "Xining", "Xinxiang", "Xinyu", "Xuzhou", "Xuzhou",
                "Xinyi", "Xiaogan", "Xichang", "Xiantao", "Xianning", "Xinzhou", "Xinzheng", "Xinmi", "Xingyang", "Xinyang",

        // Cities starting with Y
                "Yakutsk", "Yamoussoukro", "Yangon", "Yaoundé", "Yekaterinburg", "Yerevan", "York", "Yosemite", "Yokohama", "Youngstown",
                "Yuba City", "Yuncheng", "Yuxi", "Yuyao", "Yibin", "Yichang", "Yinchuan", "Yingkou", "Yiwu", "Yogyakarta",

        // Cities starting with Z
                "Zagreb", "Zanzibar", "Zaragoza", "Zermatt", "Zhengzhou", "Zurich", "Zibo", "Zihuatanejo", "Zion", "Zunyi",
                "Zamboanga", "Zanesville", "Zaozhuang", "Zapopan", "Zarqa", "Zephyrhills", "Zhangjiakou", "Zhaoqing", "Zhongshan", "Zhoukou"
    )
}
