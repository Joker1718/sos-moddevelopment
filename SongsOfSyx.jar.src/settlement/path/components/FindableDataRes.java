/*     */ package settlement.path.components;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.finder.SCompFinder;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FindableDataRes
/*     */ {
/*  16 */   static final LinkedList<FindableDataRes> all = new LinkedList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ArrayList<FindableData> datas;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int index;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final CharSequence title;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final DIR[] dirs;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RBIT.RBITImp fetchmask;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final SCompFinder.SCompPatherFinder finder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FindableDataRes(CharSequence title) {
/*  77 */     this
/*  78 */       .dirs = new DIR[] { DIR.C, DIR.N, DIR.E, DIR.S, DIR.W };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     this.finder = new SCompFinder.SCompPatherFinder()
/*     */       {
/*     */         public boolean isInComponent(SComponent c, double distance)
/*     */         {
/* 104 */           return c.ress[FindableDataRes.this.index].has((RBIT)FindableDataRes.this.fetchmask);
/*     */         }
/*     */       }; this.title = title; this.datas = new ArrayList(RESOURCES.ALL().size()); for (int i = 0; i < RESOURCES.ALL().size(); i++) this.datas.add(new Res((RESOURCE)RESOURCES.ALL().get(i)));  this.index = all.add(this);
/*     */   }
/*     */   void add(SComponent c, RESOURCE res) { ((FindableData)this.datas.get(res.index())).add(c); }
/*     */   boolean remove(SComponent c, RESOURCE res) { return ((FindableData)this.datas.get(res.index())).remove(c); }
/*     */   public int get(SComponent c, RESOURCE res) { return ((FindableData)this.datas.get(res.index())).get(c); }
/*     */   public boolean overflow(SComponent c, RESOURCE res) { return ((FindableData)this.datas.get(res.index())).overflow(c); }
/*     */   public int get(SComponent c, int res) { return ((FindableData)this.datas.get(res)).get(c); } public RBIT bits(SComponent c) { return (RBIT)c.ress[this.index]; } public RBIT bits(int sx, int sy) { SComponent s = (SETT.PATH()).comps.zero.get(sx, sy); if (s == null) return RBIT.NONE;  while (s.superComp() != null) s = s.superComp();  return (RBIT)s.ress[this.index]; } public boolean has(SComponent c, RBIT mask) { return bits(c).has(mask); } public final void reportPresence(int tx, int ty, RESOURCE res) { ((FindableData)this.datas.get(res.index())).reportPresence(tx, ty); } public final void reportAbsence(int tx, int ty, RESOURCE res) { ((FindableData)this.datas.get(res.index())).reportAbsence(tx, ty); } public boolean has(int startX, int startY, RBIT mask) { byte b; int i; DIR[] arrayOfDIR; for (i = (arrayOfDIR = this.dirs).length, b = 0; b < i; ) { DIR d = arrayOfDIR[b]; SComponent s = (SComponent)(SETT.PATH()).comps.zero.get(startX, startY, d); if (s != null) { while (s.superComp() != null) s = s.superComp();  if (has(s, mask)) return true;  }  b++; }  return false; } public SCompFinder.SCompPatherFinder finder(RBIT.RBITImp mask) { this.fetchmask = mask; return this.finder; } private final class Res extends FindableData
/*     */   {
/* 114 */     Res(RESOURCE res) { super(res.name);
/* 115 */       this.res = res; }
/*     */     
/*     */     private final RESOURCE res;
/*     */     
/*     */     void add(SComponent c) {
/* 120 */       super.add(c);
/* 121 */       c.ress[FindableDataRes.this.index].or(this.res);
/*     */     }
/*     */ 
/*     */     
/*     */     boolean remove(SComponent c) {
/* 126 */       boolean ret = super.remove(c);
/* 127 */       if (get(c) == 0) {
/* 128 */         c.ress[FindableDataRes.this.index].clear(this.res);
/*     */       }
/* 130 */       return ret;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\FindableDataRes.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */