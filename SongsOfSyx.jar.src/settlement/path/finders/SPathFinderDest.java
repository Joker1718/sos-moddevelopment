/*     */ package settlement.path.finders;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.finder.SCompFinder;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SPathFinderDest
/*     */ {
/*     */   private final PathUtilOnline p;
/*     */   
/*     */   SPathFinderDest(PathUtilOnline p) {
/*  24 */     this.p = p;
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
/*     */   PathTile findDest(int startX, int startY, SCompFinder.SCompPath comp, SFINDER finder) {
/*  39 */     SComponent parent = (SComponent)comp.path().get(0);
/*  40 */     SComponent target = parent;
/*     */ 
/*     */     
/*  43 */     if (!finder.isInComponent(target, comp.distance())) {
/*  44 */       LOG.ln("nay");
/*  45 */       LOG.ln("" + startX + " " + startX + " " + startY);
/*  46 */       LOG.ln("" + target.centreX() + " " + target.centreX());
/*  47 */       LOG.ln();
/*  48 */       return null;
/*     */     } 
/*     */     
/*  51 */     PathUtilOnline.Flooder f = this.p.getFlooder();
/*  52 */     f.init(SPathFinder.class);
/*     */     
/*  54 */     if (comp.path().size() >= 2) {
/*  55 */       parent = (SComponent)comp.path().get(1);
/*  56 */       markNeigh(parent, target);
/*     */     } else {
/*  58 */       f.pushSloppy(startX, startY, 0.0D);
/*     */     } 
/*     */ 
/*     */     
/*  62 */     int tiles = 0;
/*  63 */     while (f.hasMore()) {
/*  64 */       PathTile t = f.pollSmallest();
/*     */       
/*  66 */       tiles++;
/*     */       
/*  68 */       if (finder.isTile(t.x(), t.y(), 0)) {
/*  69 */         f.done();
/*  70 */         return t;
/*     */       } 
/*     */       
/*  73 */       if (!target.is(t.x(), t.y())) {
/*     */         continue;
/*     */       }
/*  76 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  77 */         DIR d = (DIR)DIR.ORTHO.get(i);
/*  78 */         int tx = t.x() + d.x();
/*  79 */         int ty = t.y() + d.y();
/*  80 */         if (SETT.IN_BOUNDS(tx, ty)) {
/*     */           
/*  82 */           if (finder.isTile(tx, ty, 0)) {
/*  83 */             t = f.force((short)tx, (short)ty, t.getValue2(), t);
/*  84 */             f.done();
/*  85 */             return t;
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/*  90 */           double cost = (SETT.PATH()).huristics.getCost(t.x(), t.y(), tx, ty);
/*  91 */           if (cost > 0.0D) {
/*  92 */             cost *= d.tileDistance();
/*  93 */             f.pushSmaller(tx, ty, t.getValue() + cost, t);
/*     */           }
/*  95 */           else if (cost == -1.0D) {
/*  96 */             f.close(tx, ty, 0.0D);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 103 */     if (!SETT.PATH().willUpdate()) {
/* 104 */       GAME.Notify("nono " + startX + " " + startY + " " + parent.centreX() + " " + parent.centreY() + " " + target.centreX() + " " + target.centreY() + " " + tiles + " " + String.valueOf(target.level().get(target.centreX(), target.centreY())) + " " + comp.path().size() + " " + String.valueOf(target));
/*     */     }
/*     */     
/* 107 */     f.done();
/* 108 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   final void markNeigh(SComponent current, SComponent parent) {
/* 113 */     int x1 = current.centreX() & 0xFFFFFFF8;
/* 114 */     int y1 = current.centreY() & 0xFFFFFFF8;
/*     */     
/* 116 */     if (x1 - 1 >= 0) {
/* 117 */       int i, x = x1 - 1;
/* 118 */       boolean hit = false;
/* 119 */       for (int y = -1; y < 8; y++) {
/* 120 */         if (parent.is(x, y + y1)) {
/* 121 */           this.p.getFlooder().pushSloppy(x, y + y1, 0.0D);
/* 122 */           i = hit | true;
/*     */         } 
/*     */       } 
/* 125 */       if (i != 0) {
/*     */         return;
/*     */       }
/*     */     } 
/* 129 */     if (x1 + 8 <= SETT.TWIDTH) {
/* 130 */       int i, x = x1 + 8;
/* 131 */       boolean hit = false;
/* 132 */       for (int y = 0; y <= 8; y++) {
/* 133 */         if (parent.is(x, y + y1)) {
/* 134 */           this.p.getFlooder().pushSloppy(x, y + y1, 0.0D);
/* 135 */           i = hit | true;
/*     */         } 
/*     */       } 
/* 138 */       if (i != 0) {
/*     */         return;
/*     */       }
/*     */     } 
/* 142 */     if (y1 - 1 >= 0) {
/* 143 */       int i, y = y1 - 1;
/* 144 */       boolean hit = false;
/* 145 */       for (int x = 0; x <= 8; x++) {
/* 146 */         if (parent.is(x + x1, y)) {
/* 147 */           this.p.getFlooder().pushSloppy(x + x1, y, 0.0D);
/* 148 */           i = hit | true;
/*     */         } 
/*     */       } 
/* 151 */       if (i != 0) {
/*     */         return;
/*     */       }
/*     */     } 
/* 155 */     if (y1 + 8 <= SETT.THEIGHT) {
/* 156 */       int i, y = y1 + 8;
/* 157 */       boolean hit = false;
/* 158 */       for (int x = -1; x < 8; x++) {
/* 159 */         if (parent.is(x + x1, y)) {
/* 160 */           this.p.getFlooder().pushSloppy(x + x1, y, 0.0D);
/* 161 */           i = hit | true;
/*     */         } 
/*     */       } 
/* 164 */       if (i != 0)
/*     */         return; 
/*     */     } 
/* 167 */     GAME.Error("" + parent.index() + " " + parent.index());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SPathFinderDest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */