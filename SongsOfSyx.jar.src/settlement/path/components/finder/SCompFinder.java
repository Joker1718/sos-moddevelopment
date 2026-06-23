/*     */ package settlement.path.components.finder;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SCOMPONENTS;
/*     */ import settlement.path.components.SComp0;
/*     */ import settlement.path.components.SComp0Level;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.SComponentChecker;
/*     */ import settlement.path.components.SComponentEdge;
/*     */ import settlement.path.components.SComponentLevel;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.BOOLEANO;
/*     */ 
/*     */ public final class SCompFinder
/*     */ {
/*     */   private final SCOMPONENTS comps;
/*     */   private final SComponentChecker checker;
/*     */   private final SComponentChecker[] checkers;
/*     */   
/*  32 */   private final BOOLEANO<SComponent> checkerDummy = new BOOLEANO<SComponent>()
/*     */     {
/*     */       public boolean is(SComponent t)
/*     */       {
/*  36 */         return true;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  41 */   private final SCompReal res = new SCompReal();
/*  42 */   private final SCompDummy dummy = new SCompDummy();
/*  43 */   private final SCompPatherFinder fDummy = new SCompPatherFinder()
/*     */     {
/*     */       public boolean isInComponent(SComponent c, double distance)
/*     */       {
/*  47 */         return true;
/*     */       }
/*     */     };
/*     */   private final PathUtilOnline p; private ArrayCooShort coosTmp; private final Rec rBounds;
/*     */   private final DIR[] dirs;
/*     */   
/*  53 */   public SCompFinder(PathUtilOnline p) { this((SETT.PATH()).comps, p); } public SCompPath fill(int startX, int startY, SCompPatherFinder fi, int maxDistance) { this.coosTmp.set(0).set(startX, startY); this.coosTmp.inc(); return fill(this.coosTmp, fi, maxDistance); }
/*     */   public SCompPath fill(ArrayCooShort coos, SCompPatherFinder fi, int maxDistance) { this.res.path.clearSoft(); this.res.distance = maxDistance; this.res.checker = this.checker; this.checker.init(); SComp0Level sComp0Level = this.comps.zero; this.checker.init(); PathUtilOnline.Flooder f = this.p.getFlooder(); f.init(this); int am = 0; int k = coos.getI(); for (int i = 0; i < k; i++) { coos.set(i); SComponent ss = (SComponent)sComp0Level.get(coos.get().x(), coos.get().y()); if (ss == null)
/*     */         for (int di = 0; di < DIR.ORTHO.size(); di++) { ss = (SComponent)sComp0Level.get(coos.get().x(), coos.get().y(), (DIR)DIR.ORTHO.get(di)); if (ss != null)
/*     */             break;  }   if (ss != null && !this.checker.isSetAndSet(ss)) { am++; f.pushSloppy(ss.centreX(), ss.centreY(), 0.0D); }  }
/*     */      if (am == 0) { f.done(); return this.res; }
/*     */      while (f.hasMore()) { PathTile t = f.pollSmallest(); SComponent c = (SComponent)sComp0Level.get((COORDINATE)t); if (fi.isInComponent(c, t.getValue2())) { this.res.path.add(c); this.checker.isSetAndSet(c); }
/*     */        if (t.getValue() > maxDistance)
/*     */         continue;  SComponentEdge e = c.edgefirst(); while (e != null) { if (!fi.canCross(e.to()))
/*     */           continue;  f.pushSmaller(e.to().centreX(), e.to().centreY(), t.getValue() + e.distance(), t); e = e.next(); }
/*     */        }
/*     */      f.done(); return this.res; }
/*     */   public SCompPath fill(int startX, int startY, int maxDistance) { return fill(startX, startY, this.fDummy, maxDistance); }
/*     */   public SCompPath fill(ArrayCooShort starts, int maxDistance) { return fill(starts, this.fDummy, maxDistance); }
/*  66 */   public SCompFinder(SCOMPONENTS comps, PathUtilOnline p) { this.coosTmp = new ArrayCooShort(2);
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
/*     */ 
/*     */ 
/*     */     
/* 385 */     this.rBounds = new Rec();
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
/* 617 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 622 */       .dirs = new DIR[] { DIR.C, DIR.N, DIR.E, DIR.S, DIR.W }; this.comps = comps; this.checker = new SComponentChecker((SComponentLevel)comps.zero); this.checkers = new SComponentChecker[] { this.checker, new SComponentChecker((SComponentLevel)comps.zero) }; this.p = p; } public boolean exists(int startX, int startY, SCompPatherExister f, int maxDistance) { SComponent sComponent; SComp0 sComp0 = this.comps.zero.get(startX, startY); if (sComp0 == null) return true;  while (sComp0.superComp() != null) sComponent = sComp0.superComp();  f.init(sComponent.level()); if (!f.isInComponent(sComponent, 0.0D)) return false;  for (int i = sComponent.level().level() - 1; i >= 0; i--) { f.init((SComponentLevel)this.comps.all.get(i)); if (!exists(startX, startY, f, maxDistance, (SComponentLevel)this.comps.all.get(i))) return false;  }  return true; }
/*     */   private boolean exists(int startX, int startY, SCompPatherExister fi, int maxDistance, SComponentLevel l) { SComponent start = (SComponent)l.get(startX, startY); if (start == null) return false;  PathUtilOnline.Flooder f = this.p.getFlooder(); f.init(this); f.pushSloppy(start.centreX(), start.centreY(), 0.0D); while (f.hasMore()) { PathTile t = f.pollSmallest(); SComponent c = (SComponent)l.get((COORDINATE)t); if (fi.isInComponent(c, t.getValue2())) { f.done(); return true; }  if (t.getValue() > maxDistance) continue;  SComponentEdge e = c.edgefirst(); while (e != null) { if (!fi.canCross(e.to())) continue;  f.pushSmaller(e.to().centreX(), e.to().centreY(), t.getValue() + e.distance(), t); e = e.next(); }  }  f.done(); return false; }
/*     */   public SCompPath find(int startX, int startY, SCompPatherFinder f, int maxDistance) { SComponent sComponent; PathTile t = null; SComp0 sComp0 = this.comps.zero.get(startX, startY); if (sComp0 == null) return null;  if (sComp0.superComp() == null) { t = find(startX, startY, f, maxDistance, (SComponentLevel)this.comps.zero, (BOOLEANO<SComponent>)this.checkers[1], this.checkers[0]); if (t == null) return null;  this.res.set(t, (SComponentLevel)this.comps.zero, this.checker); return this.res; }  while (sComp0.superComp() != null) sComponent = sComp0.superComp();  if (!f.isInComponent(sComponent, 0.0D)) return null;  this.checkers[sComponent.level().level() & 0x1].init(); this.checkers[sComponent.level().level() & 0x1].isSetAndSet(sComponent); for (int i = sComponent.level().level() - 1; i >= 0; i--) { t = find(startX, startY, f, maxDistance, (SComponentLevel)this.comps.all.get(i), (BOOLEANO<SComponent>)this.checkers[i + 1 & 0x1], this.checkers[i & 0x1]); if (t == null)
/*     */         return null;  }  this.res.set(t, (SComponentLevel)this.comps.zero, this.checker); return this.res; }
/* 626 */   private boolean testDest(SComponent s, int destX, int destY) { byte b; int i; DIR[] arrayOfDIR; for (i = (arrayOfDIR = this.dirs).length, b = 0; b < i; ) { DIR d = arrayOfDIR[b];
/* 627 */       SComponent de = (SComponent)(SETT.PATH()).comps.zero.get(destX, destY, d);
/* 628 */       if (de != null) {
/* 629 */         while (de.superComp() != null)
/* 630 */           de = de.superComp(); 
/* 631 */         if (de == s)
/* 632 */           return true; 
/*     */       }  b++; }
/*     */     
/* 635 */     return false; } public SCompPath find(RoomInstance startRoom, SCompPatherFinder f, int maxDistance) { SComponent sComponent; PathTile t = null; SComp0 sComp0 = this.comps.zero.get(startRoom.mX(), startRoom.mY()); if (sComp0 == null) return null;  if (sComp0.superComp() == null) { t = find(startRoom, f, maxDistance, (SComponentLevel)this.comps.zero, (BOOLEANO<SComponent>)this.checkers[1], this.checkers[0]); if (t == null) return null;  this.res.set(t, (SComponentLevel)this.comps.zero, this.checker); return this.res; }  while (sComp0.superComp() != null) sComponent = sComp0.superComp();  if (!f.isInComponent(sComponent, 0.0D)) return null;  this.checkers[sComponent.level().level() & 0x1].init(); this.checkers[sComponent.level().level() & 0x1].isSetAndSet(sComponent); for (int i = sComponent.level().level() - 1; i >= 0; i--) { t = find(startRoom, f, maxDistance, (SComponentLevel)this.comps.all.get(i), (BOOLEANO<SComponent>)this.checkers[i + 1 & 0x1], this.checkers[i & 0x1]); if (t == null) return null;  }  this.res.set(t, (SComponentLevel)this.comps.zero, this.checker); return this.res; }
/*     */   public SComponent get(int startX, int startY, SCompPatherFinder f, int maxDistance) { SComponent sComponent; PathTile t = null; SComp0 sComp0 = this.comps.zero.get(startX, startY); if (sComp0 == null) return null;  if (sComp0.superComp() == null) { t = find(startX, startY, f, maxDistance, (SComponentLevel)this.comps.zero, (BOOLEANO<SComponent>)this.checkers[1], this.checkers[0]); if (t == null) return null;  return (SComponent)this.comps.zero.get((COORDINATE)t); }  while (sComp0.superComp() != null) sComponent = sComp0.superComp();  if (!f.isInComponent(sComponent, 0.0D)) return null;  this.checkers[sComponent.level().level() & 0x1].init(); this.checkers[sComponent.level().level() & 0x1].isSetAndSet(sComponent); for (int i = sComponent.level().level() - 1; i >= 0; i--) { t = find(startX, startY, f, maxDistance, (SComponentLevel)this.comps.all.get(i), (BOOLEANO<SComponent>)this.checkers[i + 1 & 0x1], this.checkers[i & 0x1]); if (t == null) return null;  }  return (SComponent)this.comps.zero.get((COORDINATE)t); }
/*     */   public SCompPath find(int startX, int startY, SCompPatherFinder f, int maxDistance, int gridSize) { SComponent sComponent; PathTile t = null; SComp0 sComp0 = this.comps.zero.get(startX, startY); if (sComp0 == null) return this.dummy;  if (sComp0.superComp() == null) { t = find(startX, startY, f, maxDistance, (SComponentLevel)this.comps.zero, (BOOLEANO<SComponent>)this.checkers[1], this.checkers[0]); if (t == null) return null;  this.res.set(t, (SComponentLevel)this.comps.zero, this.checker); return this.res; }  while (sComp0.superComp() != null && sComp0.superComp().level().size() <= gridSize) sComponent = sComp0.superComp();  t = find(startX, startY, f, maxDistance, sComponent.level(), this.checkerDummy, this.checkers[sComponent.level().level() & 0x1]); if (t == null)
/*     */       return null;  for (int i = sComponent.level().level() - 1; i >= 0; i--) { t = find(startX, startY, f, maxDistance, (SComponentLevel)this.comps.all.get(i), (BOOLEANO<SComponent>)this.checkers[i + 1 & 0x1], this.checkers[i & 0x1]); if (t == null)
/*     */         return null;  }  this.res.set(t, (SComponentLevel)this.comps.zero, this.checker); return this.res; }
/* 640 */   private PathTile findDest(int startX, int startY, int destX, int destY, SComponentLevel l, BOOLEANO<SComponent> checker) { SComponent start = (SComponent)l.get(startX, startY);
/* 641 */     if (start == null) {
/* 642 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 646 */     PathUtilOnline.Flooder f = this.p.getFlooder();
/*     */     
/* 648 */     f.init(this);
/* 649 */     f.pushSloppy(start.centreX(), start.centreY(), 0.0D);
/* 650 */     int v = 0;
/* 651 */     while (f.hasMore()) {
/* 652 */       PathTile t = f.pollSmallest();
/* 653 */       SComponent c = (SComponent)l.get((COORDINATE)t);
/*     */       
/* 655 */       if (c == null) {
/* 656 */         f.done();
/* 657 */         return null;
/*     */       } 
/*     */       
/* 660 */       v++; byte b; int i; DIR[] arrayOfDIR;
/* 661 */       for (i = (arrayOfDIR = this.dirs).length, b = 0; b < i; ) { DIR d = arrayOfDIR[b];
/* 662 */         if (c.is(destX, destY, d)) {
/* 663 */           mark(t, l);
/* 664 */           PathTile res = t;
/* 665 */           f.done();
/* 666 */           return res;
/*     */         } 
/*     */         b++; }
/*     */       
/* 670 */       if (c.superComp() != null && !checker.is(c.superComp())) {
/*     */         continue;
/*     */       }
/* 673 */       SComponentEdge e = c.edgefirst();
/*     */       
/* 675 */       while (e != null) {
/* 676 */         SComponent to = e.to();
/* 677 */         double cost = e.cost2();
/* 678 */         e = e.next();
/* 679 */         f.pushSmaller(to.centreX(), to.centreY(), t.getValue() + cost, t);
/*     */       } 
/*     */     } 
/*     */     
/* 683 */     f.done();
/*     */     
/* 685 */     if (!SETT.PATH().willUpdate())
/* 686 */       GAME.Notify("nono " + v + " " + startX + " " + startY + " " + l.level() + " " + checker.is(start.superComp()) + " " + ((l.get(destX, destY) != null) ? checker.is(((SComponent)l.get(destX, destY)).superComp()) : 0) + " " + destX + " " + destY); 
/* 687 */     return null; }
/*     */   private PathTile find(RoomInstance startRoom, SCompPatherFinder fi, int maxDistance, SComponentLevel l, BOOLEANO<SComponent> checker, SComponentChecker marker) { SComponent start = (SComponent)l.get(startRoom.mX(), startRoom.mY()); if (start == null) return null;  maxDistance += l.size() * 2; if (maxDistance < 0) maxDistance = Integer.MAX_VALUE;  this.rBounds.setDim(l.size()); marker.init(); PathUtilOnline.Flooder f = this.p.getFlooder(); f.init(this); f.pushSloppy(start.centreX(), start.centreY(), 0.0D); f.setValue2(start.centreX(), start.centreY(), 0.0D); double v = 0.0D; boolean canCross = false; PathTile best = null; while (f.hasMore()) { PathTile t = f.pollSmallest(); SComponent c = (SComponent)l.get((COORDINATE)t); if (c == null) throw new RuntimeException(String.valueOf(l) + " " + String.valueOf(l));  boolean inRoom = false; if (t.getValue2() == 0.0F) { this.rBounds.moveX1Y1((c.centreX() & (l.size() - 1 ^ 0xFFFFFFFF)), (c.centreY() & (l.size() - 1 ^ 0xFFFFFFFF))); if (c == start || this.rBounds.touches(startRoom.body())) inRoom = true;  }  if (fi.isInComponent(c, t.getValue2())) { mark(t, l, marker); if (best == null) best = t;  if (l.level() == 0) { f.done(); return best; }  }  if (t.getValue2() > maxDistance) { v = t.getValue2(); continue; }  if (c.superComp() != null && !checker.is(c.superComp()))
/*     */         continue;  SComponentEdge e = c.edgefirst(); while (e != null) { SComponent to = e.to(); double cost = e.cost2(); double dist = e.distance(); if (inRoom) { this.rBounds.moveX1Y1((to.centreX() & (l.size() - 1 ^ 0xFFFFFFFF)), (to.centreY() & (l.size() - 1 ^ 0xFFFFFFFF))); if (this.rBounds.touches((BODY_HOLDER)startRoom)) { cost = 0.0D; dist = 0.0D; }  }  e = e.next(); if (!fi.canCross(to)) { canCross = true; continue; }  if (f.pushSmaller(to.centreX(), to.centreY(), t.getValue() + cost, t) != null)
/*     */           f.setValue2(to.centreX(), to.centreY(), t.getValue2() + dist);  }  }  f.done(); if (best != null)
/*     */       return best;  if (!canCross && !SETT.PATH().willUpdate() && maxDistance > v)
/* 692 */       GAME.Notify("nono " + maxDistance + " " + v + " " + startRoom.mX() + " " + startRoom.mY() + " " + l.level() + " " + String.valueOf(fi) + " " + checker.is(start) + " " + fi.canCross(start));  return null; } private void mark(PathTile t, SComponentLevel l) { this.checker.init();
/* 693 */     while (t != null)
/* 694 */     { SComponent c = (SComponent)l.get(t.x(), t.y());
/* 695 */       mark(c, this.checker);
/* 696 */       t = t.getParent(); }  }
/*     */   private PathTile find(int startX, int startY, SCompPatherFinder fi, int maxDistance, SComponentLevel l, BOOLEANO<SComponent> checker, SComponentChecker marker) { SComponent start = (SComponent)l.get(startX, startY); if (start == null) return null;  maxDistance += l.size() * 2; if (maxDistance < 0) maxDistance = Integer.MAX_VALUE;  marker.init(); PathUtilOnline.Flooder f = this.p.getFlooder(); f.init(this); f.pushSloppy(start.centreX(), start.centreY(), 0.0D); f.setValue2(start.centreX(), start.centreY(), 0.0D); double v = 0.0D; boolean canCross = false; PathTile best = null; while (f.hasMore()) { PathTile t = f.pollSmallest(); SComponent c = (SComponent)l.get((COORDINATE)t); if (fi.isInComponent(c, t.getValue2())) { mark(t, l, marker); if (best == null) best = t;  if (l.level() == 0) { f.done(); return best; }  }  if (t.getValue2() > maxDistance) { v = t.getValue2(); continue; }  if (c.superComp() != null && !checker.is(c.superComp())) continue;  SComponentEdge e = c.edgefirst(); while (e != null) { SComponent to = e.to(); double cost = e.cost2(); double dist = e.distance(); e = e.next(); if (!fi.canCross(to)) { canCross = true; continue; }  if (to != l.get(to.centreX(), to.centreY())) { debug(c, to); continue; }  if (f.pushSmaller(to.centreX(), to.centreY(), t.getValue() + cost, t) != null) f.setValue2(to.centreX(), to.centreY(), t.getValue2() + dist);  }  }  f.done(); if (best != null) return best;  if (!canCross && !SETT.PATH().willUpdate() && maxDistance > v) GAME.Notify("nono " + maxDistance + " " + v + " " + startX + " " + startY + " " + l.level() + " " + String.valueOf(fi) + " " + checker.is(start) + " " + fi.canCross(start));  return null; }
/*     */   private void debug(SComponent from, SComponent to) { System.err.println(to.level().level()); System.err.println("" + to.centreX() + " " + to.centreX() + " " + to.retired() + " " + to.centreY()); SComponent u = (SComponent)((SComponentLevel)(SETT.PATH()).comps.all.get(0)).get(to.centreX(), to.centreY()); while (u != null) { System.err.println("level " + u.level().level() + " " + u.retired()); System.err.println(u.superComp()); System.err.println("" + u.centreX() + " " + u.centreX()); if (u.superComp() != null) System.err.println("supC " + u.superComp().centreX() + " " + u.superComp().centreY());  u = u.superComp(); }  System.err.println(); }
/*     */   public SCompPath findDest(int startX, int startY, int destX, int destY) { SComponent sComponent1, sComponent2; SComp0 sComp01 = (SETT.PATH()).comps.zero.get(startX, startY); if (sComp01 == null) return null;  while (sComp01.superComp() != null) sComponent1 = sComp01.superComp();  if (!testDest(sComponent1, destX, destY)) return null;  PathTile t = null; SComp0 sComp02 = this.comps.zero.get(startX, startY); if (sComp02 == null) return null;  if (sComp02.superComp() == null) { t = findDest(startX, startY, destX, destY, (SComponentLevel)this.comps.zero, (BOOLEANO<SComponent>)this.checker); if (t == null)
/*     */         return null;  this.res.set(t, (SComponentLevel)this.comps.zero, this.checker); return this.res; }  while (sComp02.superComp() != null)
/*     */       sComponent2 = sComp02.superComp();  this.checker.init(); this.checker.isSetAndSet(sComponent2); for (int i = sComponent2.level().level() - 1; i >= 0; i--) { t = findDest(startX, startY, destX, destY, (SComponentLevel)this.comps.all.get(i), (BOOLEANO<SComponent>)this.checker); if (t == null)
/* 702 */         return null;  }  this.res.set(t, (SComponentLevel)this.comps.zero, this.checker); return this.res; } private void mark(PathTile t, SComponentLevel l, SComponentChecker checker) { while (t != null) {
/* 703 */       SComponent c = (SComponent)l.get(t.x(), t.y());
/* 704 */       mark(c, checker);
/* 705 */       t = t.getParent();
/*     */     }  }
/*     */ 
/*     */ 
/*     */   
/*     */   private void mark(SComponent c, SComponentChecker checker) {
/* 711 */     checker.isSetAndSet(c);
/* 712 */     SComponentEdge e = c.edgefirst();
/* 713 */     while (e != null) {
/* 714 */       checker.isSetAndSet(e.to());
/* 715 */       e = e.next();
/*     */     } 
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
/*     */   public static interface SCompPatherFinder
/*     */   {
/*     */     default boolean canCross(SComponent c) {
/* 734 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isInComponent(SComponent param1SComponent, double param1Double);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final class SCompReal
/*     */     implements SCompPath
/*     */   {
/* 750 */     private final ArrayListResize<SComponent> path = new ArrayListResize(SComp0Level.startSize, 2147483647);
/*     */     
/*     */     private double distance;
/*     */     private SComponentChecker checker;
/*     */     
/*     */     public boolean is(int tile) {
/* 756 */       SComp0 sComp0 = SCompFinder.this.comps.zero.get(tile);
/* 757 */       if (sComp0 != null && this.checker.isSet(sComp0.index()))
/* 758 */         return true; 
/* 759 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(int tx, int ty) {
/* 764 */       if (SETT.IN_BOUNDS(tx, ty)) {
/* 765 */         SComp0 sComp0 = SCompFinder.this.comps.zero.get(tx, ty);
/* 766 */         if (sComp0 != null && this.checker.isSet(sComp0.index()))
/* 767 */           return true; 
/*     */       } 
/* 769 */       return false;
/*     */     }
/*     */     
/*     */     private void set(PathTile t, SComponentLevel l, SComponentChecker checker) {
/* 773 */       this.distance = t.getValue();
/* 774 */       this.checker = checker;
/* 775 */       this.path.clearSoft();
/* 776 */       while (t != null) {
/* 777 */         SComponent c = (SComponent)l.get(t.x(), t.y());
/*     */         
/* 779 */         this.path.add(c);
/* 780 */         t = t.getParent();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public LIST<SComponent> path() {
/* 786 */       return (LIST<SComponent>)this.path;
/*     */     }
/*     */ 
/*     */     
/*     */     public double distance() {
/* 791 */       return this.distance;
/*     */     }
/*     */   }
/*     */   
/*     */   private final class SCompDummy
/*     */     implements SCompPath {
/*     */     private ArrayList<SComponent> path;
/*     */     
/*     */     private SCompDummy() {
/* 800 */       this.path = new ArrayList(0);
/*     */     }
/*     */     
/*     */     public boolean is(int tile) {
/* 804 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(int tx, int ty) {
/* 809 */       if (SETT.IN_BOUNDS(tx, ty)) {
/* 810 */         return true;
/*     */       }
/* 812 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public LIST<SComponent> path() {
/* 817 */       return (LIST<SComponent>)this.path;
/*     */     }
/*     */ 
/*     */     
/*     */     public double distance() {
/* 822 */       return 0.0D;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface SCompPath extends MAP_BOOLEAN {
/*     */     LIST<SComponent> path();
/*     */     
/*     */     double distance();
/*     */   }
/*     */   
/*     */   public static interface SCompPatherExister extends SCompPatherFinder {
/*     */     void init(SComponentLevel param1SComponentLevel);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\finder\SCompFinder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */