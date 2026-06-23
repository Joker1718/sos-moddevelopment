/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StatHome
/*     */   implements StatsInit.StatDisposable
/*     */ {
/*     */   private final INT_O.INT_OE<Induvidual> xx;
/*     */   private final INT_O.INT_OE<Induvidual> yy;
/*     */   private final STATData stat;
/*     */   public final STAT hasSearched;
/*     */   public final INFO info;
/*     */   private Coo coo;
/*     */   
/*     */   StatHome(StatsInit init) {
/* 488 */     this.coo = new Coo(); this.info = new INFO(Dic.¤¤Home, StatsHome.¤¤desc); init.count.getClass(); this.xx = (INT_O.INT_OE<Induvidual>)new DataO.DataShort(init.count, "HOME_XX"); init.count.getClass(); this.yy = (INT_O.INT_OE<Induvidual>)new DataO.DataShort(init.count, "HOME_YY"); INT_O.INT_OE<Induvidual> b = new INT_O.INT_OE<Induvidual>() {
/*     */         public int get(Induvidual t) { return (StatsHome.StatHome.this.xx.get(t) != 0) ? 1 : 0; } public int min(Induvidual t) { return 0; } public int max(Induvidual t) { return 1; } public void set(Induvidual t, int i) {}
/*     */       }; this.stat = new STATData("HOUSED", "HOME_HOUSE", init, b); (this.stat.info()).icon = (SETT.ROOMS()).HOME.icon.medium; init.disposable.add(this); init.count.getClass(); this.hasSearched = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataBit(init.count, "HOME_SEARCH"));
/* 491 */   } public boolean has(Humanoid h) { return (this.xx.get(h.indu()) != 0); } public COORDINATE hCoo(Humanoid f) { if (this.xx.get(f.indu()) == 0)
/* 492 */       return null; 
/* 493 */     this.coo.set((this.xx.get(f.indu()) - 1), (this.yy.get(f.indu()) - 1));
/* 494 */     return (COORDINATE)this.coo; }
/*     */   public boolean has(Induvidual h) { return (this.xx.get(h) != 0); }
/*     */   public HOME get(Induvidual f, Object user) { if (this.xx.get(f) == 0)
/*     */       return null;  int tx = this.xx.get(f) - 1; int ty = this.yy.get(f) - 1;
/* 498 */     return HOME.get(tx, ty); } public HOME get(Humanoid h, Object user) { return get(h.indu(), user); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose(Humanoid h) {
/* 503 */     STATS.HOME().dump(h);
/* 504 */     set(h, null);
/*     */   }
/*     */   
/*     */   public void set(Humanoid h, HOME home) {
/* 508 */     if (h.isRemoved() || SETT.ENTITIES().getByID(h.id()) != h)
/* 509 */       throw new RuntimeException("" + h.isRemoved() + " " + h.isRemoved()); 
/* 510 */     Induvidual f = h.indu();
/* 511 */     this.hasSearched.indu().set(f, 0);
/* 512 */     this.stat.removeH(f);
/*     */     
/* 514 */     HOME ho = get(h.indu(), this);
/* 515 */     if (ho != null) {
/* 516 */       ho.vacate(h);
/*     */     }
/*     */     
/* 519 */     if (home != null) {
/*     */       
/* 521 */       this.xx.set(f, home.serviceX() + 1);
/* 522 */       this.yy.set(f, home.serviceY() + 1);
/* 523 */       home.occupy(h);
/*     */     } else {
/*     */       
/* 526 */       this.xx.set(f, 0);
/* 527 */       this.yy.set(f, 0);
/*     */     } 
/*     */     
/* 530 */     this.stat.addH(f);
/*     */   }
/*     */ 
/*     */   
/*     */   public STAT stat() {
/* 535 */     return (STAT)this.stat;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsHome$StatHome.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */