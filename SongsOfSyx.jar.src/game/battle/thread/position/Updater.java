/*     */ package game.battle.thread.position;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormation;
/*     */ import game.battle.formation.DivPositionCopyable;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Updater
/*     */ {
/*     */   volatile boolean stop = false;
/*  16 */   private final Rec body = new Rec();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void init(DivCentres.Context c) {
/*  24 */     for (short di = 0; di < c.statuses.length; di = (short)(di + 1)) {
/*  25 */       if (this.stop)
/*     */         return; 
/*  27 */       Div d = GAME.ARMIES().division(di);
/*  28 */       init(c, d);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void init(DivCentres.Context c, Div d) {
/*  35 */     DivCentre s = c.statuses[d.index()];
/*  36 */     s.clear();
/*     */ 
/*     */     
/*  39 */     if (d.menNrOf() == 0)
/*     */       return; 
/*  41 */     DivPositionCopyable pos = d.current();
/*  42 */     if (pos.deployed() == 0)
/*     */       return; 
/*  44 */     DivFormation form = d.position();
/*  45 */     double am = 0.0D;
/*  46 */     for (int i = 0; i < form.deployed() && i < pos.deployed(); i++) {
/*  47 */       if (d.reporter.reachable(i)) {
/*     */         
/*  49 */         double dist = COORDINATE.tileDistance(form.px(i), form.py(i), pos.px(i), pos.py(i));
/*  50 */         if (dist < 64.0D) {
/*  51 */           double a = 1.0D - dist / 64.0D;
/*  52 */           a = CLAMP.d(a, 0.0D, 1.0D);
/*  53 */           am += a;
/*     */         } 
/*     */       } 
/*     */     } 
/*  57 */     s.inPosition = (short)(int)am;
/*     */     
/*  59 */     int xx = 0;
/*  60 */     int yy = 0;
/*  61 */     am = 0.0D;
/*     */     int pi;
/*  63 */     for (pi = 0; pi < pos.deployed(); pi++) {
/*  64 */       if (d.reporter.reachable(pi)) {
/*  65 */         int x = pos.px(pi);
/*  66 */         int y = pos.py(pi);
/*  67 */         if (pi == 0) {
/*  68 */           this.body.clear();
/*  69 */           this.body.moveX1Y1(x, y);
/*  70 */           this.body.setDim(1.0D, 1.0D);
/*     */         } else {
/*  72 */           this.body.unify(x, y);
/*     */         } 
/*  74 */         xx += x;
/*  75 */         yy += y;
/*  76 */         am++;
/*     */       } 
/*     */     } 
/*     */     
/*  80 */     if (am == 0.0D) {
/*  81 */       for (pi = 0; pi < pos.deployed(); pi++) {
/*  82 */         int x = pos.px(pi);
/*  83 */         int y = pos.py(pi);
/*  84 */         if (pi == 0) {
/*  85 */           this.body.clear();
/*  86 */           this.body.moveX1Y1(x, y);
/*  87 */           this.body.setDim(1.0D, 1.0D);
/*     */         } else {
/*  89 */           this.body.unify(x, y);
/*     */         } 
/*  91 */         xx += x;
/*  92 */         yy += y;
/*  93 */         am++;
/*     */       } 
/*     */     }
/*     */     
/*  97 */     s.squareCX = this.body.cX();
/*  98 */     s.squareCY = this.body.cY();
/*     */     
/* 100 */     if (am == 0.0D) {
/* 101 */       s.cx = -1;
/* 102 */       s.cy = -1;
/*     */     } else {
/* 104 */       xx = (int)(xx / am);
/* 105 */       yy = (int)(yy / am);
/*     */       
/* 107 */       s.cxSoft = xx;
/* 108 */       s.cySoft = yy;
/* 109 */       int best = -1;
/* 110 */       int bestV = Integer.MAX_VALUE;
/*     */       
/* 112 */       for (int j = 0; j < pos.deployed(); j++) {
/* 113 */         int dist = Math.abs(xx - pos.px(j)) + Math.abs(yy - pos.py(j));
/*     */         
/* 115 */         if (!d.reporter.reachable(j)) {
/* 116 */           dist += 1073741823;
/*     */         }
/*     */         
/* 119 */         if (dist < bestV) {
/* 120 */           best = j;
/* 121 */           bestV = dist;
/*     */         } 
/*     */       } 
/*     */       
/* 125 */       xx = pos.px(best);
/* 126 */       yy = pos.py(best);
/*     */     } 
/*     */     
/* 129 */     s.cx = xx;
/* 130 */     s.cy = yy;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\position\Updater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */