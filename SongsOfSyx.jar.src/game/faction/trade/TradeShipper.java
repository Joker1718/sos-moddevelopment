/*     */ package game.faction.trade;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayListShort;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.region.RD;
/*     */ 
/*     */ final class TradeShipper
/*     */   implements SAVABLE
/*     */ {
/*  20 */   private final Partner[] partners = new Partner[FACTIONS.MAX()];
/*  21 */   private final ArrayListShort neighFactions = new ArrayListShort(FACTIONS.MAX());
/*     */ 
/*     */   
/*     */   public TradeShipper() {
/*  25 */     for (int i = 0; i < this.partners.length; i++) {
/*  26 */       this.partners[i] = new Partner(FACTIONS.getByIndex(i));
/*     */     }
/*     */   }
/*     */   
/*     */   public void save(FilePutter file) {
/*  31 */     this.neighFactions.save(file); int i;
/*  32 */     for (i = 0; i < partners(); i++) {
/*  33 */       file.d((partner(i)).distance);
/*     */     }
/*  35 */     for (i = 0; i < partners(); i++) {
/*  36 */       TR.MAP().saver().save((partner(i)).traded, file);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  43 */     this.neighFactions.load(file); int i;
/*  44 */     for (i = 0; i < partners(); i++) {
/*  45 */       (partner(i)).distance = file.d();
/*     */     }
/*  47 */     for (i = 0; i < partners(); i++) {
/*  48 */       TR.MAP().loader().load((partner(i)).traded, file, 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  54 */     this.neighFactions.clear();
/*     */   }
/*     */   
/*     */   void init(Faction buyer) {
/*  58 */     if (buyer.capitolRegion() == null)
/*     */       return; 
/*  60 */     this.neighFactions.clear();
/*  61 */     for (WRegFinder.RegDist d : RD.DIST().tradePartners(buyer)) {
/*  62 */       if (d.reg.faction() == buyer) {
/*     */         continue;
/*     */       }
/*     */       
/*  66 */       Partner p = this.partners[d.reg.faction().index()];
/*  67 */       Arrays.fill(p.traded, 0);
/*  68 */       p.distance = d.distance;
/*  69 */       this.neighFactions.add(d.reg.faction().index());
/*     */     } 
/*     */   }
/*     */   
/*     */   public Partner popNextPartner() {
/*  74 */     int i = this.neighFactions.remove(this.neighFactions.size() - 1);
/*  75 */     return this.partners[i];
/*     */   }
/*     */   
/*     */   public boolean hasNextPartner() {
/*  79 */     return (this.neighFactions.size() > 0);
/*     */   }
/*     */   
/*     */   public int partners() {
/*  83 */     return this.neighFactions.size();
/*     */   }
/*     */   
/*     */   public Partner partner(int i) {
/*  87 */     return this.partners[this.neighFactions.get(i)];
/*     */   }
/*     */   
/*     */   static final class Partner
/*     */   {
/*     */     private final short faction;
/*     */     private double distance;
/*  94 */     private final int[] traded = Alloc.ii(TR.ALL().size());
/*     */     
/*     */     Partner(Faction faction) {
/*  97 */       this.faction = (short)faction.index();
/*     */     }
/*     */     
/*     */     public Faction faction() {
/* 101 */       return FACTIONS.getByIndex(this.faction);
/*     */     }
/*     */     
/*     */     public double distance() {
/* 105 */       return this.distance;
/*     */     }
/*     */     
/*     */     public int traded(TRADABLE res) {
/* 109 */       return this.traded[res.index()];
/*     */     }
/*     */     
/*     */     public void trade(TRADABLE res, int amount) {
/* 113 */       this.traded[res.index()] = this.traded[res.index()] + amount;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\trade\TradeShipper.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */