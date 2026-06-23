/*     */ package game.faction.player;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.paths.PATHS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.STOCKPILE;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.value.GVALUES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.data.BOOLEANO;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class PBonusSetting implements SAVABLE {
/*  42 */   private static CharSequence ¤¤name = "¤Setting";
/*  43 */   private static CharSequence ¤¤mode = "¤Mode:";
/*  44 */   private final ArrayListGrower<BoostSpecs.ParseValue> boosts = new ArrayListGrower();
/*     */   
/*  46 */   public final STOCKPILE.StockpileImp startResources = new STOCKPILE.StockpileImp();
/*  47 */   public int startLevel = 0;
/*  48 */   public String mode = "";
/*     */   
/*     */   static {
/*  51 */     D.ts(PBonusSetting.class);
/*     */   } protected PBonusSetting() {
/*     */     byte b;
/*     */     int i;
/*     */     String[] arrayOfString;
/*  56 */     for (i = (arrayOfString = (PATHS.PLAYER()).init.getFolder("mode").getFiles()).length, b = 0; b < i; ) { final String k = arrayOfString[b];
/*     */       
/*  58 */       Json j = new Json((PATHS.PLAYER()).text.getFolder("mode").get(k));
/*  59 */       String n = j.text("NAME");
/*  60 */       GVALUES.FACTION.push("PLAY_MODE_" + k, String.valueOf(¤¤mode) + " " + String.valueOf(¤¤mode), (SPRITE)(UI.icons()).s.cog, new BOOLEANO<Faction>()
/*     */           {
/*     */             public boolean is(Faction t)
/*     */             {
/*  64 */               return k.equals(PBonusSetting.this.mode);
/*     */             }
/*     */           });
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(String key, double am, boolean isMul) {
/*  74 */     if ((isMul && am == 1.0D) || am == 0.0D)
/*     */       return; 
/*  76 */     BoostSpecs.ParseValue a = new BoostSpecs.ParseValue(key, am, isMul);
/*  77 */     if (add(a))
/*     */     {
/*  79 */       this.boosts.add(a);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean add(BoostSpecs.ParseValue a) {
/*  86 */     String key = a.key;
/*  87 */     double am = a.am;
/*  88 */     boolean isMul = a.isMul;
/*  89 */     LIST<Boostable> bb = BOOSTING.MAP().get(key);
/*  90 */     if (bb == null) {
/*  91 */       LOG.err(key);
/*  92 */       return false;
/*     */     } 
/*  94 */     for (Boostable b : bb) {
/*     */       
/*  96 */       BValue.BValuePlayerOnly bValuePlayerOnly = new BValue.BValuePlayerOnly()
/*     */         {
/*     */           
/*     */           public double vGet(FactionNPC f)
/*     */           {
/* 101 */             return 0.0D;
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(Player f) {
/* 106 */             return 1.0D;
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(HCLASS_RACE t) {
/* 111 */             if (b == (BOOSTABLES.BEHAVIOUR()).HAPPI && 
/* 112 */               t.cl == HCLASSES.CITIZEN() && (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(t.race) == 0) {
/* 113 */               return 0.0D;
/*     */             }
/* 115 */             return 1.0D;
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/* 121 */       BoosterValue boosterValue = new BoosterValue((BValue)bValuePlayerOnly, new BSourceInfo(¤¤name, (SPRITE)(UI.icons()).s.alert), am, isMul);
/*     */       
/* 123 */       boosterValue.add(b);
/*     */     } 
/*     */     
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 132 */     file.i(this.boosts.size());
/*     */     
/* 134 */     for (BoostSpecs.ParseValue a : this.boosts) {
/* 135 */       file.chars(a.key);
/* 136 */       file.d(a.am);
/* 137 */       file.bool(a.isMul);
/*     */     } 
/* 139 */     this.startResources.save(file);
/* 140 */     file.i(this.startLevel);
/* 141 */     file.chars(this.mode);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 146 */     this.boosts.clear();
/* 147 */     int am = file.i();
/*     */     
/* 149 */     for (int i = 0; i < am; i++) {
/* 150 */       BoostSpecs.ParseValue a = new BoostSpecs.ParseValue(file.chars(), file.d(), file.bool());
/* 151 */       if (add(a))
/* 152 */         this.boosts.add(a); 
/*     */     } 
/* 154 */     this.startResources.load(file);
/* 155 */     this.startLevel = file.i();
/* 156 */     this.mode = file.chars();
/*     */     
/* 158 */     if (this.mode.length() > 0) {
/* 159 */       setMode(this.mode);
/*     */     }
/*     */   }
/*     */   
/*     */   public void copy(PBonusSetting old) {
/* 164 */     this.boosts.clear();
/* 165 */     for (BoostSpecs.ParseValue a : old.boosts)
/* 166 */       add(a); 
/* 167 */     for (int ri = 0; ri < RESOURCES.ALL().size(); ri++) {
/* 168 */       this.startResources.set((RESOURCE)RESOURCES.ALL().get(ri), old.startResources.get(ri));
/*     */     }
/* 170 */     this.startLevel = old.startLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {}
/*     */ 
/*     */   
/*     */   public void apply() {
/* 179 */     if (this.startLevel > 0) {
/* 180 */       FACTIONS.player().level().set(this.startLevel);
/*     */     }
/* 182 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 183 */     f.init(this);
/* 184 */     int ri = 0;
/*     */ 
/*     */     
/* 187 */     f.pushSloppy(THRONE.coo(), 0.0D);
/*     */     
/* 189 */     while (f.hasMore()) {
/* 190 */       PathTile t = f.pollSmallest();
/*     */       
/* 192 */       if (!(SETT.PATH()).solidity.is((COORDINATE)t) && (SETT.THINGS()).resources.get(t.x(), t.y()) == null) {
/*     */         
/* 194 */         while (ri < RESOURCES.ALL().size()) {
/* 195 */           int am = this.startResources.get(ri);
/* 196 */           if (am > 0) {
/*     */             
/* 198 */             if (am > 100)
/* 199 */               am = 100; 
/* 200 */             this.startResources.inc(RESOURCES.ALL().get(ri), -am);
/* 201 */             (SETT.THINGS()).resources.create((COORDINATE)t, (RESOURCE)RESOURCES.ALL().get(ri), am);
/*     */             break;
/*     */           } 
/* 204 */           ri++;
/*     */         } 
/*     */ 
/*     */         
/* 208 */         if (ri >= RESOURCES.ALL().size()) {
/*     */           break;
/*     */         }
/* 211 */         for (DIR d : DIR.ORTHO) {
/* 212 */           if (!(SETT.PATH()).solidity.is((COORDINATE)t, d)) {
/* 213 */             f.pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 219 */     f.done();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMode(String selectedMode) {
/* 224 */     if (!(PATHS.PLAYER().folder("mode")).init.exists(selectedMode))
/*     */       return; 
/* 226 */     Json j = new Json((PATHS.PLAYER().folder("mode")).init.gets(selectedMode));
/*     */     
/* 228 */     j = j.json("BOOST");
/*     */     
/* 230 */     for (String k : j.keys()) {
/* 231 */       BoostSpecs.ParseValue v = new BoostSpecs.ParseValue(j, k);
/* 232 */       add(v);
/*     */     } 
/*     */     
/* 235 */     this.mode = selectedMode;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PBonusSetting.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */