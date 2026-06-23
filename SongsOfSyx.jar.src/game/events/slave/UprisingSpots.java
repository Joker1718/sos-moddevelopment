/*     */ package game.events.slave;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.COORDINATEE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ 
/*     */ public final class UprisingSpots
/*     */ {
/*  25 */   private ArrayList<UprisingSpot> spots = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*     */   private int divI;
/*     */   private int inposition;
/*  28 */   private final Coo position = new Coo();
/*     */   
/*  30 */   private int[] amountsTotal = Alloc.ii(RACES.all().size());
/*  31 */   private int[] signedUps = Alloc.ii(RACES.all().size());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double dri;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int riot(double amountD) {
/*  42 */     clear();
/*     */     
/*  44 */     if (!UprisingSpot.setStart((COORDINATEE)this.position, THRONE.coo().x(), THRONE.coo().y(), 128)) {
/*  45 */       return 0;
/*     */     }
/*  47 */     int amountTotal = 0;
/*  48 */     GAME.BATTLE_THREADS().pause();
/*  49 */     for (int ri = 0; ri < RACES.all().size(); ri++) {
/*     */       
/*  51 */       Race r = (Race)RACES.all().get(ri);
/*  52 */       int am = (int)(STATS.POP().pop(r, HTYPES.SLAVE()) * amountD);
/*     */ 
/*     */       
/*  55 */       if (am > 0) {
/*  56 */         int sp = (int)Math.ceil(am / (Config.battle()).MEN_PER_DIVISION);
/*  57 */         sp = CLAMP.i(sp, 0, this.spots.max());
/*     */         
/*  59 */         int menPerSpot = (int)Math.ceil(am / sp);
/*  60 */         for (int i = 0; i < sp && this.spots.size() < (Config.battle()).DIVISIONS_PER_ARMY; i++) {
/*     */           
/*  62 */           int a = CLAMP.i(menPerSpot, 0, am);
/*  63 */           am -= a;
/*     */           
/*  65 */           UprisingSpot s = UprisingSpot.make(this.position.x(), this.position.y(), a, r);
/*  66 */           this.amountsTotal[s.race] = this.amountsTotal[s.race] + s.amountTotal;
/*  67 */           if (s != null) {
/*  68 */             this.spots.add(s);
/*  69 */             amountTotal += s.amountTotal;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  76 */     GAME.BATTLE_THREADS().unpause(true);
/*     */ 
/*     */     
/*  79 */     return amountTotal;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean hasMore() {
/*  84 */     return (this.spots.size() > 0);
/*     */   }
/*     */   
/*     */   void save(FilePutter file) {
/*  88 */     file.i(this.divI);
/*  89 */     file.i(0);
/*  90 */     file.i(0);
/*  91 */     file.i(this.inposition);
/*  92 */     this.position.save(file);
/*  93 */     file.i(this.spots.size());
/*  94 */     for (UprisingSpot s : this.spots)
/*  95 */       s.save(file); 
/*     */   }
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  99 */     this.divI = file.i();
/* 100 */     file.i();
/* 101 */     file.i();
/* 102 */     this.inposition = file.i();
/* 103 */     this.position.load(file);
/* 104 */     int am = file.i();
/* 105 */     this.spots.clear();
/* 106 */     for (int i = 0; i < am; i++) {
/* 107 */       this.spots.add(UprisingSpot.make(file));
/*     */     }
/* 109 */     Arrays.fill(this.amountsTotal, 0);
/* 110 */     Arrays.fill(this.signedUps, 0);
/* 111 */     for (UprisingSpot s : this.spots) {
/* 112 */       this.amountsTotal[s.race] = this.amountsTotal[s.race] + s.amountTotal;
/* 113 */       this.signedUps[s.race] = this.signedUps[s.race] + s.signedUp;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 121 */     this.spots.clear();
/* 122 */     this.divI = 0;
/* 123 */     Arrays.fill(this.amountsTotal, 0);
/* 124 */     Arrays.fill(this.signedUps, 0);
/* 125 */     this.inposition = 0;
/*     */   }
/*     */   
/*     */   public boolean shouldSignUpUpriser(Humanoid h) {
/* 129 */     return (this.signedUps[h.race().index()] < this.amountsTotal[h.race().index()]);
/*     */   }
/*     */   
/*     */   public int signUpUpriserPositionByte(Humanoid h) {
/* 133 */     for (int i = 0; i < this.spots.size(); i++) {
/* 134 */       if (((UprisingSpot)this.spots.get(i)).race == h.race().index() && ((UprisingSpot)this.spots.get(i)).signedUp < ((UprisingSpot)this.spots.get(i)).amountTotal) {
/* 135 */         ((UprisingSpot)this.spots.get(i)).signedUp++;
/* 136 */         this.signedUps[((UprisingSpot)this.spots.get(i)).race] = this.signedUps[((UprisingSpot)this.spots.get(i)).race] + 1;
/* 137 */         return i;
/*     */       } 
/*     */     } 
/* 140 */     return -1;
/*     */   }
/*     */   
/*     */   public boolean confirmUpriser(int positionByte) {
/* 144 */     if (positionByte < 0 || positionByte >= this.spots.size())
/* 145 */       return false; 
/* 146 */     return (((UprisingSpot)this.spots.get(positionByte)).signedUp <= ((UprisingSpot)this.spots.get(positionByte)).amountTotal);
/*     */   }
/*     */   
/*     */   public void reportUpriserInPosition(int positionByte) {
/* 150 */     if (positionByte < 0 || positionByte >= this.spots.size())
/*     */       return; 
/* 152 */     this.inposition++;
/*     */   }
/*     */   
/*     */   public void cancelUpriser(Humanoid h, int positionByte, boolean inPosition) {
/* 156 */     if (positionByte < 0 || positionByte >= this.spots.size())
/*     */       return; 
/* 158 */     ((UprisingSpot)this.spots.get(positionByte)).signedUp--;
/* 159 */     this.signedUps[(h.race()).index] = this.signedUps[(h.race()).index] - 1;
/* 160 */     if (inPosition) {
/* 161 */       this.inposition--;
/*     */     }
/*     */   }
/*     */   
/*     */   public COORDINATE getUpriserTile(int positionByte) {
/* 166 */     return (COORDINATE)this.spots.get(positionByte);
/*     */   }
/*     */   UprisingSpots() {
/* 169 */     this.dri = 0.0D;
/*     */   }
/*     */   
/*     */   boolean update(double ds) {
/* 173 */     this.dri += ds;
/*     */     
/* 175 */     if (this.dri < 1.0D) {
/* 176 */       return false;
/*     */     }
/*     */     
/* 179 */     for (int i = 0; i < this.spots.size(); i++) {
/* 180 */       ((UprisingSpot)this.spots.get(i)).validate();
/*     */     }
/*     */     
/* 183 */     this.dri--;
/*     */     
/* 185 */     for (Race r : RACES.all()) {
/* 186 */       if (this.amountsTotal[r.index] > STATS.POP().pop(r, HTYPES.SLAVE())) {
/* 187 */         for (int k = 0; k < this.spots.size(); k++) {
/* 188 */           if (((UprisingSpot)this.spots.get(k)).race == r.index() && ((UprisingSpot)this.spots.get(k)).amountTotal > 0) {
/* 189 */             ((UprisingSpot)this.spots.get(k)).amountTotal--;
/* 190 */             this.amountsTotal[r.index] = this.amountsTotal[r.index] - 1;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 196 */     int amTot = 0;
/* 197 */     for (int j = 0; j < this.spots.size(); j++) {
/* 198 */       amTot += ((UprisingSpot)this.spots.get(j)).amountTotal;
/*     */     }
/* 200 */     if (this.inposition >= amTot) {
/* 201 */       (GAME.ARMIES()).factors.init(GAME.ARMIES().enemy(), 1.0D);
/* 202 */       while (nextDivision() && this.spots.size() > 0) {
/* 203 */         Div d = (Div)GAME.ARMIES().enemy().divisions().get(this.divI);
/* 204 */         ((UprisingSpot)this.spots.removeLast()).makeDiv(d, this.spots.size());
/*     */       } 
/* 206 */       clear();
/* 207 */       (GAME.ARMIES()).factors.init(GAME.ARMIES().enemy(), 1.0D);
/* 208 */       return true;
/*     */     } 
/*     */     
/* 211 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean nextDivision() {
/* 217 */     if (this.divI >= (Config.battle()).DIVISIONS_PER_ARMY) {
/* 218 */       return false;
/*     */     }
/* 220 */     while (((Div)GAME.ARMIES().enemy().divisions().get(this.divI)).menNrOf() > 0) {
/* 221 */       this.divI++;
/*     */       
/* 223 */       if (this.divI >= (Config.battle()).DIVISIONS_PER_ARMY) {
/* 224 */         return false;
/*     */       }
/*     */     } 
/* 227 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\slave\UprisingSpots.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */