/*     */ package game.battle.div;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.DivisionBanners;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.training.ROOM_M_TRAINER;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public final class DivInfo
/*     */   implements DIV_SPEC.DIV_SPECE
/*     */ {
/*  27 */   private final Str name = new Str(32);
/*     */   private final Div div;
/*     */   private int menTarget;
/*     */   private int raceI;
/*     */   private int exMin;
/*     */   private int symbolI;
/*  33 */   private final DOUBLE.DoubleImp[] trains = new DOUBLE.DoubleImp[ROOM_M_TRAINER.ALL().size()];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final SAVABLE saver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Div div() {
/*  45 */     return this.div;
/*     */   }
/*     */ 
/*     */   
/*     */   public int men() {
/*  50 */     return this.menTarget;
/*     */   }
/*     */ 
/*     */   
/*     */   public void menSet(int am) {
/*  55 */     if (this.div.army() == GAME.ARMIES().player()) {
/*  56 */       (SETT.BATTLE()).info.clearTargets();
/*     */     }
/*     */     
/*  59 */     this.menTarget = CLAMP.i(am, 0, this.div.men.freeSpots() + this.div.menNrOf());
/*     */   }
/*     */ 
/*     */   
/*     */   public double equip(EquipBattle e) {
/*  64 */     return e.target(this.div) / e.equipMax;
/*     */   }
/*     */ 
/*     */   
/*     */   public void equipSet(EquipBattle e, double d) {
/*  69 */     e.targetSet(this.div, (int)Math.round(d * e.max()));
/*     */   }
/*     */ 
/*     */   
/*     */   public double training(StatsBattle.StatTraining e) {
/*  74 */     return this.trains[e.room.INDEX_TRAINING].getD();
/*     */   }
/*     */ 
/*     */   
/*     */   public void trainingSet(StatsBattle.StatTraining e, double d) {
/*  79 */     this.trains[e.room.INDEX_TRAINING].setD(d);
/*     */   }
/*     */ 
/*     */   
/*     */   public double experience() {
/*  84 */     return (STATS.BATTLE()).COMBAT_EXPERIENCE.div().getD(this.div);
/*     */   }
/*     */ 
/*     */   
/*     */   public Faction faction() {
/*  89 */     return (Faction)FACTIONS.player();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Race race() {
/*  98 */     return (Race)RACES.all().get(this.raceI);
/*     */   }
/*     */ 
/*     */   
/*     */   public void raceSet(Race race) {
/* 103 */     int men = men();
/* 104 */     menSet(0);
/* 105 */     this.raceI = race.index;
/* 106 */     menSet(men);
/*     */   }
/*     */   
/*     */   public DivisionBanners.DivisionBanner banner() {
/* 110 */     return (GAME.ARMIES()).banners.get(this.symbolI);
/*     */   }
/*     */ 
/*     */   
/*     */   public Str name() {
/* 115 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public int bannerI() {
/* 120 */     return this.symbolI;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   DivInfo(Div div) {
/* 144 */     this.saver = new SAVABLE() { public void save(FilePutter file) {
/*     */           byte b;
/*     */           int i;
/*     */           DOUBLE.DoubleImp[] arrayOfDoubleImp;
/* 148 */           for (i = (arrayOfDoubleImp = DivInfo.this.trains).length, b = 0; b < i; ) { DOUBLE.DoubleImp t = arrayOfDoubleImp[b];
/* 149 */             t.save(file);
/*     */             
/*     */             b++; }
/*     */           
/* 153 */           file.i(DivInfo.this.menTarget);
/* 154 */           file.i(DivInfo.this.raceI);
/* 155 */           file.i(DivInfo.this.exMin);
/* 156 */           file.i(DivInfo.this.symbolI);
/* 157 */           DivInfo.this.name.save(file);
/*     */         } public void load(FileGetter file) throws IOException {
/*     */           byte b;
/*     */           int i;
/*     */           DOUBLE.DoubleImp[] arrayOfDoubleImp;
/* 162 */           for (i = (arrayOfDoubleImp = DivInfo.this.trains).length, b = 0; b < i; ) { DOUBLE.DoubleImp t = arrayOfDoubleImp[b];
/* 163 */             t.load(file); b++; }
/*     */           
/* 165 */           DivInfo.this.menTarget = file.i();
/* 166 */           DivInfo.this.raceI = file.i();
/* 167 */           DivInfo.this.exMin = file.i();
/* 168 */           DivInfo.this.symbolI = file.i();
/* 169 */           DivInfo.this.name.load(file);
/*     */         } public void clear() {
/*     */           byte b;
/*     */           int i;
/*     */           DOUBLE.DoubleImp[] arrayOfDoubleImp;
/* 174 */           for (i = (arrayOfDoubleImp = DivInfo.this.trains).length, b = 0; b < i; ) { DOUBLE.DoubleImp t = arrayOfDoubleImp[b];
/* 175 */             t.setD(0.0D); b++; }
/*     */           
/* 177 */           DivInfo.this.menTarget = 0;
/* 178 */           DivInfo.this.raceI = (FACTIONS.player().race()).index;
/* 179 */           DivInfo.this.exMin = 0;
/* 180 */           DivInfo.this.symbolI = DivInfo.this.div.index();
/* 181 */           DivInfo.this.name.clear().add(Dic.¤¤Division).add(' ').add('#').add(DivInfo.this.div.index());
/*     */         } }
/*     */       ;
/*     */     this.div = div;
/*     */     this.raceI = 0;
/*     */     this.symbolI = div.index();
/*     */     this.name.clear().add(Dic.¤¤Division).add(' ').add('#').add(div.index());
/*     */     for (int i = 0; i < this.trains.length; i++)
/*     */       this.trains[i] = new DOUBLE.DoubleImp(); 
/*     */   }
/*     */   public Str nameE() {
/* 192 */     return this.name;
/*     */   }
/*     */   public void experienceSet(double experience) {}
/*     */   
/*     */   public void bannerISet(int bannerI) {
/* 197 */     this.symbolI = bannerI;
/*     */   }
/*     */   
/*     */   public void factionSet(Faction faction) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\div\DivInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */