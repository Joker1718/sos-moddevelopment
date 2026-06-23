/*     */ package world.region;
/*     */ 
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.text.D;
/*     */ import world.map.regions.Region;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ public class RDOwner
/*     */   implements RD.RDUpdatable {
/*  20 */   private static CharSequence ¤¤Affiliation = "¤Support";
/*  21 */   private static CharSequence ¤¤AffiliationD = "¤Support towards your majesty. Low support increases the chance of rebellion. When a region is controlled, support will increase with time. For other regions, emissaries can be sent to increase support.";
/*     */   
/*     */   static {
/*  24 */     D.ts(RDOwner.class);
/*     */   }
/*     */   
/*  27 */   private static final double dTime = 1.0D / (TIME.secondsPerDay() * 8);
/*     */   
/*     */   public final INT_O.INT_OE<Region> affiliation;
/*     */   private final INT_O.INT_OE<Region> prevOwner;
/*     */   private final INT_O.INT_OE<Region> prevOwnerII;
/*     */   public final INT_O.INT_OE<Region> ownerI;
/*     */   
/*     */   RDOwner(RD.RDInit init) {
/*  35 */     init.count.getClass(); this.affiliation = (INT_O.INT_OE<Region>)new DataO.DataByte(init.count, "OWNER", ¤¤Affiliation, ¤¤AffiliationD);
/*  36 */     init.count.getClass(); this.prevOwner = (INT_O.INT_OE<Region>)new DataO.DataShort(init.count, "PREVOWVER");
/*  37 */     init.count.getClass(); this.prevOwnerII = (INT_O.INT_OE<Region>)new DataO.DataNibble(init.count, "PREVOWNER2");
/*  38 */     init.count.getClass(); this.ownerI = (INT_O.INT_OE<Region>)new DataO.DataByte(init.count, "OWNERI");
/*  39 */     init.upers.add(this);
/*     */ 
/*     */ 
/*     */     
/*  43 */     BOOSTING.connecter(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  47 */             RBooster b = new RBooster(new BSourceInfo(RDOwner.¤¤Affiliation, (SPRITE)(UI.icons()).s.happy), 0.0D, 1.0D, true)
/*     */               {
/*     */                 public double get(Region t)
/*     */                 {
/*  51 */                   if (t.faction() == FACTIONS.player())
/*  52 */                     return (RDOwner.null.access$0(RDOwner.null.this)).affiliation.getD(t); 
/*  53 */                   return 1.0D;
/*     */                 }
/*     */               };
/*     */ 
/*     */             
/*  58 */             for (RDRace r : (RD.RACES()).all) {
/*  59 */               b.add(r.loyalty.target);
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(Region reg, double time) {
/*  68 */     int tar = 255;
/*  69 */     double d = 255.0D * time * dTime;
/*  70 */     if (reg.faction() == FACTIONS.player()) {
/*  71 */       tar = 255;
/*  72 */       this.affiliation.moveTo(reg, d, tar);
/*  73 */     } else if (reg.faction() != FACTIONS.player()) {
/*  74 */       double dd = (FACTIONS.player()).emissaries.assimilate.getD(reg) * (FACTIONS.player()).emissaries.penaltyMul();
/*  75 */       if (dd <= 0.0D) {
/*  76 */         this.affiliation.moveTo(reg, d * 0.25D, 0);
/*     */       } else {
/*  78 */         this.affiliation.moveTo(reg, 255.0D * time * dTime * dd, 255);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  83 */     if (prevOwner(reg) == null) {
/*  84 */       Faction ff = reg.faction();
/*  85 */       if (ff != null) {
/*  86 */         this.prevOwner.set(reg, ff.index() + 1);
/*  87 */         if (ff instanceof FactionNPC) {
/*  88 */           this.prevOwnerII.set(reg, ((FactionNPC)ff).iteration() & 0xF);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(Region reg) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Faction prevOwner(Region reg) {
/* 101 */     int i = this.prevOwner.get(reg);
/* 102 */     if (i != 0) {
/* 103 */       Faction f = FACTIONS.getByIndex(i - 1);
/* 104 */       if (f == null || !f.isActive() || (f instanceof FactionNPC && this.prevOwnerII.get(reg) != (((FactionNPC)f).iteration() & 0xF))) {
/* 105 */         this.prevOwner.set(reg, 0);
/* 106 */         return null;
/*     */       } 
/*     */       
/* 109 */       return f;
/*     */     } 
/* 111 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDOwner.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */