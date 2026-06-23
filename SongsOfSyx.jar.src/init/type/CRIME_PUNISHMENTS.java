/*     */ package init.type;
/*     */ 
/*     */ import init.INIT;
/*     */ import init.paths.PATHS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.law.StatPunishment;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ 
/*     */ public class CRIME_PUNISHMENTS
/*     */ {
/*  27 */   private static CharSequence ¤¤freedom = "Crime Tyranny Multiplier";
/*  28 */   private static CharSequence ¤¤law = "Crime Law Multiplier";
/*     */   static {
/*  30 */     D.ts(CRIME_PUNISHMENTS.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private final PUNISHMENT PARDON;
/*     */   private final PUNISHMENT STOCKS;
/*     */   private final PUNISHMENT BANISH;
/*     */   private final PUNISHMENT PRISON;
/*     */   private final PUNISHMENT EXECUTE;
/*     */   private final PUNISHMENT HARVEST;
/*     */   private final PUNISHMENT ENSLAVE;
/*     */   private final LIST<PUNISHMENT> all;
/*     */   private final LIST<PUNISHMENT> CITIZENS;
/*     */   private final LIST<PUNISHMENT> SLAVES;
/*     */   private final LIST<PUNISHMENT> WAR;
/*     */   private static CRIME_PUNISHMENTS self;
/*     */   
/*     */   CRIME_PUNISHMENTS(INIT init) throws IOException {
/*  48 */     self = this;
/*  49 */     ArrayListGrower<PUNISHMENT> all = new ArrayListGrower();
/*     */     
/*  51 */     Json json = (new Json((PATHS.CONFIG()).init.gets("LAW"))).json("PUNISHMENTS");
/*  52 */     Json desc = (new Json((PATHS.CONFIG()).text.gets("LAW"))).json("PUNISHMENTS");
/*     */     
/*  54 */     this.PARDON = new PUNISHMENT(json, desc, (LISTE<PUNISHMENT>)all, "PARDON");
/*  55 */     this.STOCKS = new PUNISHMENT(json, desc, (LISTE<PUNISHMENT>)all, "NONE");
/*  56 */     this.BANISH = new PUNISHMENT(json, desc, (LISTE<PUNISHMENT>)all, "BANISH");
/*  57 */     this.PRISON = new PUNISHMENT(json, desc, (LISTE<PUNISHMENT>)all, "PRISON");
/*  58 */     this.EXECUTE = new PUNISHMENT(json, desc, (LISTE<PUNISHMENT>)all, "EXECUTE");
/*  59 */     this.HARVEST = new PUNISHMENT(json, desc, (LISTE<PUNISHMENT>)all, "HARVEST");
/*  60 */     this.ENSLAVE = new PUNISHMENT(json, desc, (LISTE<PUNISHMENT>)all, "ENSLAVE");
/*  61 */     this.all = (LIST<PUNISHMENT>)all;
/*  62 */     this.CITIZENS = (LIST<PUNISHMENT>)new ArrayList((Object[])new PUNISHMENT[] { this.PARDON, this.STOCKS, this.BANISH, this.PRISON, this.ENSLAVE, this.EXECUTE, this.HARVEST });
/*  63 */     this.SLAVES = (LIST<PUNISHMENT>)new ArrayList((Object[])new PUNISHMENT[] { this.PARDON, this.STOCKS, this.BANISH, this.PRISON, this.EXECUTE, this.HARVEST });
/*  64 */     this.WAR = (LIST<PUNISHMENT>)new ArrayList((Object[])new PUNISHMENT[] { this.PARDON, this.STOCKS, this.BANISH, this.ENSLAVE, this.EXECUTE, this.HARVEST });
/*     */     
/*  66 */     for (PUNISHMENT c : this.CITIZENS) {
/*  67 */       c.available[HCLASSES.CITIZEN().index()] = true;
/*     */     }
/*     */     
/*  70 */     for (PUNISHMENT c : this.SLAVES) {
/*  71 */       c.available[HCLASSES.SLAVE().index()] = true;
/*     */     }
/*     */     
/*  74 */     for (PUNISHMENT c : this.WAR) {
/*  75 */       c.available[HCLASSES.OTHER().index()] = true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static LIST<PUNISHMENT> get(HCLASS cl) {
/*  80 */     if (cl == HCLASSES.CITIZEN())
/*  81 */       return self.CITIZENS; 
/*  82 */     if (cl == HCLASSES.SLAVE())
/*  83 */       return self.SLAVES; 
/*  84 */     return self.WAR;
/*     */   }
/*     */   
/*     */   public static PUNISHMENT STOCKS() {
/*  88 */     return self.STOCKS;
/*     */   }
/*     */   
/*     */   public static PUNISHMENT PARDON() {
/*  92 */     return self.PARDON;
/*     */   }
/*     */   
/*     */   public static PUNISHMENT BANISH() {
/*  96 */     return self.BANISH;
/*     */   }
/*     */   
/*     */   public static PUNISHMENT PRISON() {
/* 100 */     return self.PRISON;
/*     */   }
/*     */   
/*     */   public static PUNISHMENT EXECUTE() {
/* 104 */     return self.EXECUTE;
/*     */   }
/*     */   
/*     */   public static PUNISHMENT ENSLAVE() {
/* 108 */     return self.ENSLAVE;
/*     */   }
/*     */   
/*     */   public static PUNISHMENT HARVEST() {
/* 112 */     return self.HARVEST;
/*     */   }
/*     */   
/*     */   public static LIST<PUNISHMENT> ALL() {
/* 116 */     return self.all;
/*     */   }
/*     */   
/*     */   public static class PUNISHMENT implements INDEXED {
/*     */     public CharSequence name;
/*     */     public CharSequence names;
/*     */     public CharSequence action;
/*     */     public CharSequence verb;
/*     */     public CharSequence desc;
/*     */     private final int index;
/*     */     public final String key;
/*     */     public final Icon icon;
/*     */     private final double value;
/*     */     private final double cruelty;
/*     */     private final double mercy;
/* 131 */     private final boolean[] available = new boolean[HCLASSES.ALL().size()];
/*     */     
/*     */     PUNISHMENT(Json json, Json text, LISTE<PUNISHMENT> all, String key) throws IOException {
/* 134 */       this.index = all.add(this);
/*     */       
/* 136 */       this.key = key;
/* 137 */       Json t = text.json(key);
/* 138 */       this.name = t.text("NAME");
/* 139 */       this.names = t.text("NAMES");
/* 140 */       this.action = t.text("ACTION");
/* 141 */       this.verb = t.text("VERB");
/* 142 */       this.desc = t.text("DESC");
/*     */       
/* 144 */       Json j = json.json(key);
/*     */       
/* 146 */       this.icon = SPRITES.icons().get(j);
/* 147 */       this.value = j.d("VALUE", 0.0D, 1.0D);
/* 148 */       this.mercy = j.dTry("MERCY", 0.0D, 1.0D, 0.0D);
/* 149 */       this.cruelty = j.dTry("CRUELTY", 0.0D, 1.0D, 0.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int index() {
/* 155 */       return this.index;
/*     */     }
/*     */     
/*     */     public double defaultValue() {
/* 159 */       return this.value;
/*     */     }
/*     */     
/*     */     public double crueltyValue(HCLASS cl, Race race) {
/* 163 */       return this.cruelty;
/*     */     }
/*     */     
/*     */     public double crueltyPerPerson(HCLASS cl, Race race) {
/* 167 */       return 100.0D * this.cruelty / (1 + POP.tot());
/*     */     }
/*     */     
/*     */     public double mercyValue(HCLASS cl, Race race) {
/* 171 */       return this.mercy;
/*     */     }
/*     */     
/*     */     public double mercyPerPerson(HCLASS cl, Race race) {
/* 175 */       return 100.0D * this.mercy / POP.tot();
/*     */     }
/*     */     
/*     */     public double tyranny(HCLASS cl, Race race) {
/* 179 */       if (race == null) {
/* 180 */         double pop = 0.0D;
/* 181 */         double v = 0.0D;
/* 182 */         for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 183 */           int p = (STATS.POP()).POP.data(cl).get(RACES.all().get(ri));
/* 184 */           pop += p;
/* 185 */           v += p * ((Race)RACES.all().get(ri)).pref().punishment(this);
/*     */         } 
/* 187 */         if (pop == 0.0D)
/* 188 */           return this.value; 
/* 189 */         return v / pop;
/*     */       } 
/* 191 */       return race.pref().punishment(this);
/*     */     }
/*     */     
/*     */     public double law(HCLASS cl, Race race) {
/* 195 */       return Math.sqrt(tyranny(cl, race));
/*     */     }
/*     */     
/*     */     public StatPunishment stat() {
/* 199 */       return (StatPunishment)(STATS.LAW()).punishments.get(this.index);
/*     */     }
/*     */     
/*     */     public boolean available(HCLASS cl) {
/* 203 */       return this.available[cl.index()];
/*     */     }
/*     */     
/*     */     public void hoverInfo(GUI_BOX text, HCLASS cl, Race race) {
/* 207 */       GBox b = (GBox)text;
/* 208 */       b.title(this.name);
/* 209 */       b.text(this.desc);
/*     */       
/* 211 */       b.NL();
/*     */       
/* 213 */       b.textLL(CRIME_PUNISHMENTS.¤¤freedom);
/* 214 */       b.tab(6);
/* 215 */       b.add((SPRITE)GFORMAT.perc(b.text(), tyranny(cl, race)));
/* 216 */       b.NL();
/*     */       
/* 218 */       b.textLL(CRIME_PUNISHMENTS.¤¤law);
/* 219 */       b.tab(6);
/* 220 */       b.add((SPRITE)GFORMAT.perc(b.text(), law(cl, race)));
/* 221 */       b.NL();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 227 */       return "PUN_" + this.key;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\CRIME_PUNISHMENTS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */