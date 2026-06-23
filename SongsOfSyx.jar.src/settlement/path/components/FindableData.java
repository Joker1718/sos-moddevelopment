/*     */ package settlement.path.components;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.GUTIL;
/*     */ import util.data.DataOSimple;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ class FindableData
/*     */   implements INT_O<SComponent>
/*     */ {
/*  19 */   static LinkedList<FindableData> all = new LinkedList();
/*     */   
/*     */   public final CharSequence name;
/*     */   final INT_O.INT_OE<SComponent> data;
/*     */   final INT_O.INT_OE<SComponent> overflow;
/*     */   static DataOSimple<SComponent> datao;
/*     */   
/*     */   FindableData(CharSequence name) {
/*  27 */     this.name = name;
/*  28 */     datao.getClass(); this.data = (INT_O.INT_OE<SComponent>)new DataOSimple.DataByte(datao);
/*  29 */     datao.getClass(); this.overflow = (INT_O.INT_OE<SComponent>)new DataOSimple.DataBit(datao);
/*  30 */     all.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int min(SComponent c) {
/*  35 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(SComponent c) {
/*  40 */     return 15;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(SComponent c) {
/*  45 */     return this.data.get(c);
/*     */   }
/*     */   
/*     */   public boolean overflow(SComponent c) {
/*  49 */     return this.overflow.isMax(c);
/*     */   }
/*     */   
/*     */   void add(SComponent c) {
/*  53 */     if (this.data.isMax(c)) {
/*  54 */       this.overflow.set(c, 1);
/*     */     } else {
/*  56 */       this.data.inc(c, 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   boolean remove(SComponent c) {
/*  62 */     int a = this.data.get(c);
/*     */     
/*  64 */     if (a == 0) {
/*  65 */       if (this.overflow.get(c) == 0) {
/*  66 */         if (c.level().level() > 0) {
/*  67 */           GUTIL.filler().init(this);
/*  68 */           GUTIL.filler().fill(c.centreX(), c.centreY());
/*     */           
/*  70 */           SComponentLevel l = (SComponentLevel)(SETT.PATH()).comps.all.get(c.level().level() - 1);
/*     */           
/*  72 */           while (GUTIL.filler().hasMore()) {
/*  73 */             COORDINATE coo = GUTIL.filler().poll();
/*  74 */             SComponent s = (SComponent)l.get(coo);
/*     */             
/*  76 */             SComponentEdge e = s.edgefirst();
/*  77 */             while (e != null) {
/*  78 */               if (e.to().superComp() == c) {
/*  79 */                 GUTIL.filler().fill(e.to().centreX(), e.to().centreY());
/*     */               }
/*  81 */               e = e.next();
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/*  86 */           GUTIL.filler().done();
/*     */         } 
/*  88 */         GAME.Notify(String.valueOf(this.name) + " " + String.valueOf(this.name) + " " + c.centreX() + " " + c.centreY());
/*     */       } 
/*     */       
/*  91 */       return true;
/*     */     } 
/*  93 */     this.data.inc(c, -1);
/*  94 */     if (a == 0 && 
/*  95 */       this.overflow.get(c) == 1) {
/*  96 */       return true;
/*     */     }
/*  98 */     return false;
/*     */   }
/*     */ 
/*     */   
/* 102 */   private static final LIST<DIR> dirs = (new ArrayList((Iterable)DIR.ORTHO)).join((Object[])new DIR[] { DIR.C });
/*     */   
/*     */   private static final void uncheck(int tx, int ty) {
/* 105 */     for (DIR d : dirs) {
/* 106 */       SComponent n = (SComponent)(SETT.PATH()).comps.zero.get(tx, ty, d);
/* 107 */       if (n != null) {
/* 108 */         n.checked = false;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void reportPresence(int tx, int ty) {
/* 114 */     uncheck(tx, ty);
/*     */     
/* 116 */     for (DIR d : dirs) {
/* 117 */       SComponent n = (SComponent)(SETT.PATH()).comps.zero.get(tx, ty, d);
/* 118 */       if (n != null && !n.checked) {
/* 119 */         n.checked = true;
/* 120 */         add(n);
/*     */ 
/*     */         
/* 123 */         while (n.superComp() != null && get(n) == 1) {
/* 124 */           n = n.superComp();
/* 125 */           add(n);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void reportAbsence(int tx, int ty) {
/* 135 */     uncheck(tx, ty);
/* 136 */     boolean up = false;
/* 137 */     for (DIR d : dirs) {
/* 138 */       SComponent n = (SComponent)(SETT.PATH()).comps.zero.get(tx, ty, d);
/* 139 */       if (n != null && !n.checked) {
/*     */         
/* 141 */         n.checked = true;
/* 142 */         int old = get(n);
/* 143 */         up |= remove(n);
/* 144 */         while (n.superComp() != null && old == 1) {
/* 145 */           n = n.superComp();
/* 146 */           old = get(n);
/* 147 */           up |= remove(n);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 153 */     if (up)
/* 154 */       (SETT.PATH()).comps.updateService(tx, ty); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\FindableData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */