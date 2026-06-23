/*     */ package init.race;
/*     */ 
/*     */ import game.raiding.RaiderTextsRace;
/*     */ import init.paths.PATHS;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.info.INFO;
/*     */ 
/*     */ public final class RaceInfo
/*     */   extends INFO {
/*     */   public final String namePosessive;
/*     */   public final String namePosessives;
/*     */   public final String desc_long;
/*     */   public final String initialChallenge;
/*     */   public final String[] pros;
/*     */   public final String[] cons;
/*     */   public final String[] raiderNames;
/*     */   public final RaiderTextsRace raiderMess;
/*     */   public final RaceWorldInfo winfo;
/*  25 */   private static KeyMap<RaceWorldInfo> wi = new KeyMap();
/*  26 */   private static KeyMap<String[]> ra = new KeyMap();
/*  27 */   private static KeyMap<RaiderTextsRace> ram = new KeyMap();
/*     */   
/*     */   public final LIST<String> armyNames;
/*     */   public final RPronoun pHE;
/*     */   public final RPronoun pHIS;
/*     */   public final RPronoun pHIMSELF;
/*     */   public final RPronoun pHIM;
/*     */   public final RPronoun pCHILD;
/*     */   public final CharSequence[] sHello;
/*     */   public final CharSequence[] sGoodbye;
/*     */   public final CharSequence[] sCurse;
/*     */   public final CharSequence[] sInsult;
/*     */   public final CharSequence[] sInsulting;
/*     */   public final CharSequence[] sLord;
/*     */   public final CharSequence[] sCity;
/*     */   public final CharSequence[] sOthers;
/*     */   public final CharSequence[] sSelves;
/*     */   public final CharSequence[] sSelf;
/*     */   public final CharSequence[] sChildren;
/*     */   
/*     */   RaceInfo(Json json, Json text) {
/*  48 */     super(text);
/*  49 */     this.namePosessive = text.text("POSSESSIVE");
/*  50 */     this.namePosessives = text.text("POSSESSIVES");
/*  51 */     this.desc_long = text.text("DESC_LONG");
/*     */     
/*  53 */     this.initialChallenge = text.text("CHALLENGE", "");
/*     */     
/*  55 */     this.pros = text.textsTry("PROS");
/*  56 */     this.cons = text.textsTry("CONS");
/*     */     
/*  58 */     this.pHE = new RPronoun("PRONOUN_HE", text);
/*  59 */     this.pHIS = new RPronoun("PRONOUN_HIS", text);
/*  60 */     this.pHIMSELF = new RPronoun("PRONOUN_HIMSELF", text);
/*  61 */     this.pHIM = new RPronoun("PRONOUN_HIM", text);
/*  62 */     this.pCHILD = new RPronoun("PRONOUN_CHILD", text);
/*     */     
/*  64 */     this.armyNames = (LIST<String>)new ArrayList((Object[])text.texts("ARMY_NAMES", 1, 255));
/*     */     
/*  66 */     String f = json.value("WORLD_NAME_FILE");
/*  67 */     if (!wi.containsKey(f)) {
/*  68 */       wi.put(f, new RaceWorldInfo(f));
/*     */     }
/*  70 */     this.winfo = (RaceWorldInfo)wi.get(f);
/*     */     
/*  72 */     f = json.value("RAID_TEXT_FILE");
/*  73 */     if (!ram.containsKey(f))
/*  74 */       ram.put(f, new RaiderTextsRace(new Json((PATHS.RACE()).text.getFolder("raider").getFolder("message").gets(f)))); 
/*  75 */     this.raiderMess = (RaiderTextsRace)ram.get(f);
/*     */     
/*  77 */     f = json.value("RAIDER_NAME_FILE");
/*  78 */     if (!ra.containsKey(f)) {
/*  79 */       ra.put(f, (new Json((PATHS.RACE()).text.getFolder("raider").getFolder("name").gets(f))).texts("NAMES"));
/*     */     }
/*     */ 
/*     */     
/*  83 */     this.raiderNames = (String[])ra.get(f);
/*     */ 
/*     */     
/*  86 */     this.sHello = (CharSequence[])text.texts("HELLO");
/*  87 */     this.sGoodbye = (CharSequence[])text.texts("GOODBYE");
/*  88 */     this.sCurse = (CharSequence[])text.texts("CURSE");
/*  89 */     this.sInsult = (CharSequence[])text.texts("INSULT");
/*  90 */     this.sInsulting = (CharSequence[])text.texts("INSULTING");
/*  91 */     this.sLord = (CharSequence[])text.texts("LORD");
/*  92 */     this.sCity = (CharSequence[])text.texts("CITY");
/*  93 */     this.sOthers = (CharSequence[])text.texts("OTHERS");
/*  94 */     this.sSelves = (CharSequence[])text.texts("SELVES");
/*  95 */     this.sSelf = (CharSequence[])text.texts("SELF");
/*  96 */     this.sChildren = (CharSequence[])text.texts("CHILDREN");
/*     */   }
/*     */   
/*     */   public final class RaceWorldInfo
/*     */   {
/*     */     public final String[] intros;
/*     */     public final String[] fNames;
/*     */     public final String[] rIntro;
/*     */     public final String[] rNames;
/*     */     
/*     */     RaceWorldInfo(String key) {
/* 107 */       Json json = new Json(PATHS.NAMES().getFolder("world").gets(key));
/* 108 */       this.intros = json.texts("INTRO", 1, 128);
/* 109 */       this.fNames = json.texts("NAMES", 1, 512);
/* 110 */       this.rIntro = json.texts("RULER_INTRO", 1, 128);
/* 111 */       this.rNames = json.texts("RULER", 1, 512);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class RPronoun
/*     */   {
/*     */     public final CharSequence[] pronouns;
/*     */     
/*     */     public final CharSequence[] pronounsC;
/*     */     
/*     */     RPronoun(String key, Json text) {
/* 123 */       this.pronouns = (CharSequence[])text.texts(key);
/* 124 */       this.pronounsC = (CharSequence[])text.texts(key + "C");
/*     */     }
/*     */     
/*     */     public CharSequence get(Induvidual i, boolean cap) {
/* 128 */       int k = (STATS.APPEARANCE()).gender.get(i);
/* 129 */       return get(k, cap);
/*     */     }
/*     */     
/*     */     public CharSequence get(int gender, boolean cap) {
/* 133 */       int k = gender;
/* 134 */       CharSequence[] ll = this.pronouns;
/* 135 */       if (cap)
/* 136 */         ll = this.pronounsC; 
/* 137 */       k = CLAMP.i(k, 0, ll.length - 1);
/* 138 */       return ll[k];
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\RaceInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */