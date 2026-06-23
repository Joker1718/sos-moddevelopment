/*     */ package game.battle.thread.general.offence;
/*     */ import game.GAME;
/*     */ import game.battle.thread.general.StrategosUtil;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import settlement.thing.projectiles.Trajectory;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.LISTE;
/*     */ 
/*     */ class StepArtilleryBombard {
/*  17 */   private final int absSize = 8; private final Bitmap2D mapArt; private final Bitmap2D mapBreak;
/*     */   private final StrategosUtil c;
/*     */   
/*     */   StepArtilleryBombard(StrategosUtil context) {
/*  21 */     int wi = (int)Math.ceil(SETT.TWIDTH / 8.0D);
/*  22 */     int hi = (int)Math.ceil(SETT.THEIGHT / 8.0D);
/*  23 */     this.mapArt = new Bitmap2D(wi, hi, false);
/*  24 */     this.mapBreak = new Bitmap2D(wi, hi, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  30 */     this.ins = new ArrayListResize(256);
/*  31 */     this.tmp = new ArrayList(32);
/*  32 */     this.traj = new Trajectory();
/*     */ 
/*     */     
/*  35 */     this.c = context;
/*     */   }
/*     */   private final ArrayListResize<ArtilleryInstance> ins; private final ArrayList<ArtilleryInstance> tmp; private final Trajectory traj;
/*     */   void bombard() {
/*  39 */     this.ins.clearSoft();
/*     */     
/*  41 */     for (int ai = 0; ai < (SETT.ROOMS()).ARTILLERY.size(); ai++) {
/*  42 */       ((ROOM_ARTILLERY)(SETT.ROOMS()).ARTILLERY.get(ai)).threadInstances((LISTE)this.ins);
/*     */     }
/*  44 */     for (int ii = 0; ii < this.ins.size(); ii++) {
/*  45 */       ArtilleryInstance i = (ArtilleryInstance)this.ins.get(ii);
/*  46 */       if (i.menMustering() == 0.0D || i.isFiring() || i.army() != this.c.getArmy()) {
/*  47 */         this.ins.remove(ii);
/*  48 */         ii--;
/*     */       } 
/*     */     } 
/*     */     
/*  52 */     if (this.ins.size() > 0) {
/*     */       
/*  54 */       this.mapBreak.clear();
/*  55 */       for (int y = 0; y < SETT.THEIGHT; y++) {
/*  56 */         for (int x = 0; x < SETT.TWIDTH; x++) {
/*  57 */           if ((SETT.PATH()).availability.get(x, y).isSolid(this.c.getArmy()) || (GAME.ARMIES()).map.attackable.is(x, y, this.c.getArmy())) {
/*  58 */             int i = x / 8;
/*  59 */             int j = y / 8;
/*  60 */             this.mapBreak.set(i, j, true);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  66 */       for (ArtilleryInstance i : this.ins) {
/*  67 */         int j = i.mX() / 8;
/*  68 */         int k = i.mY() / 8;
/*     */         
/*  70 */         this.mapArt.set(j, k, true);
/*     */       } 
/*     */ 
/*     */       
/*  74 */       PathUtilOnline.Flooder f = this.c.flooder.getFlooder();
/*  75 */       f.init(this);
/*     */ 
/*     */       
/*  78 */       int ax = this.c.getDestCoo().x() / 8;
/*  79 */       int ay = this.c.getDestCoo().y() / 8;
/*  80 */       f.pushSloppy(ax, ay, 0.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  85 */       while (f.hasMore() && this.ins.size() > 0) {
/*  86 */         PathTile t = f.pollSmallest();
/*  87 */         if (this.mapArt.is((COORDINATE)t)) {
/*  88 */           pushTarget(t, this.ins);
/*     */           
/*     */           continue;
/*     */         } 
/*  92 */         for (int di = 0; di < DIR.ALL.size(); di++) {
/*  93 */           DIR d = (DIR)DIR.ALL.get(di);
/*  94 */           int dx = t.x() + d.x();
/*  95 */           int dy = t.y() + d.y();
/*  96 */           if (this.mapBreak.body().holdsPoint(dx, dy)) {
/*  97 */             double v = (this.mapBreak.is(dx, dy) ? 8 : true);
/*  98 */             f.pushSmaller(dx, dy, t.getValue() + v * d.tileDistance(), t);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 104 */       f.done();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void pushTarget(PathTile t, ArrayListResize<ArtilleryInstance> ins) {
/* 111 */     this.tmp.clearSloppy();
/* 112 */     double min = Double.MAX_VALUE;
/* 113 */     double max = 0.0D;
/*     */ 
/*     */     
/* 116 */     for (ArtilleryInstance i : ins) {
/* 117 */       int ax = i.mX() / 8;
/* 118 */       int ay = i.mY() / 8;
/* 119 */       if (ax == t.x() && ay == t.y() && 
/* 120 */         this.tmp.hasRoom()) {
/* 121 */         min = Math.min(min, i.rangeMin());
/* 122 */         max = Math.max(max, i.rangeMax());
/* 123 */         this.tmp.add(i);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 128 */     min *= min;
/* 129 */     max *= max;
/*     */ 
/*     */ 
/*     */     
/* 133 */     if (this.tmp.size() == 0) {
/*     */       return;
/*     */     }
/* 136 */     int ox = t.x();
/* 137 */     int oy = t.y();
/* 138 */     while (t != null && this.tmp.size() > 0) {
/* 139 */       PathTile p = t;
/* 140 */       t = t.getParent();
/* 141 */       double dx = ((ox - p.x()) * 8);
/* 142 */       double dy = ((oy - p.y()) * 8);
/* 143 */       double d = dx * dx + dy * dy;
/* 144 */       if (d < min) {
/*     */         continue;
/*     */       }
/* 147 */       if (d > max)
/*     */         continue; 
/* 149 */       if (this.mapBreak.is((COORDINATE)p)) {
/* 150 */         push(p, this.tmp);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void push(PathTile t, ArrayList<ArtilleryInstance> ins) {
/* 159 */     int x1 = t.x() * 8;
/* 160 */     int y1 = t.y() * 8;
/*     */     
/* 162 */     for (int dy = 0; dy < 8; dy++) {
/* 163 */       for (int dx = 0; dx < 8 && this.tmp.size() > 0; dx++) {
/* 164 */         int x = x1 + dx;
/* 165 */         int y = y1 + dy;
/*     */         
/* 167 */         if ((SETT.PATH()).availability.get(x, y).isSolid(this.c.getArmy()) || (GAME.ARMIES()).map.attackable.is(x, y, this.c.getArmy()))
/* 168 */           for (ArtilleryInstance i : this.tmp) {
/* 169 */             if (i.testTarget(x, y, this.traj, false) == null) {
/* 170 */               i.targetCooSet(x, y, false, false);
/* 171 */               this.tmp.remove(i);
/* 172 */               ins.remove(i);
/*     */               break;
/*     */             } 
/*     */           }  
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\StepArtilleryBombard.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */