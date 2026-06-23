/*     */ package game.faction.diplomacy.deal;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import java.io.Serializable;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class DealSave
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final int fi;
/*     */   private final int fii;
/*     */   public final boolean[] bools;
/*     */   public final Party player;
/*     */   public final Party npc;
/*     */   
/*     */   public DealSave(Deal deal) {
/*  30 */     this.fi = deal.npc.npc().index();
/*  31 */     this.fii = deal.npc.npc().iteration();
/*  32 */     this.bools = new boolean[deal.bools.all().size()];
/*  33 */     for (int i = 0; i < this.bools.length; i++) {
/*  34 */       this.bools[i] = ((DealBool)deal.bools.all().get(i)).is();
/*     */     }
/*  36 */     this.player = new Party(deal.player);
/*  37 */     this.npc = new Party(deal.npc);
/*     */   }
/*     */ 
/*     */   
/*  41 */   private static CharSequence ¤¤Faction = "The faction of this agreement does no longer exist.";
/*  42 */   private static CharSequence ¤¤You = "You currently do not have the means to fulfill this agreement. ({0})";
/*  43 */   private static CharSequence ¤¤Other = "The faction currently does not have the means to fulfill this agreement.";
/*     */   
/*     */   static {
/*  46 */     D.ts(DealSave.class);
/*     */   }
/*     */   
/*     */   public CharSequence set(Deal deal) {
/*  50 */     FactionNPC npc = f();
/*  51 */     if (npc == null)
/*  52 */       return ¤¤Faction; 
/*  53 */     deal.setFactionAndClear(npc);
/*  54 */     for (int i = 0; i < this.bools.length; i++) {
/*  55 */       ((DealBool)deal.bools.all().get(i)).set(this.bools[i]);
/*     */     }
/*  57 */     if (this.player.set(deal.player) != null)
/*  58 */       return (CharSequence)Str.TMP.clear().add(¤¤You).insert(0, this.player.set(deal.player)); 
/*  59 */     if (this.npc.set(deal.npc) != null)
/*  60 */       return ¤¤Other; 
/*  61 */     return null;
/*     */   }
/*     */   
/*     */   public FactionNPC f() {
/*  65 */     Faction f = FACTIONS.getByIndex(this.fi);
/*  66 */     if (f == null || !f.isActive() || !(f instanceof FactionNPC))
/*  67 */       return null; 
/*  68 */     FactionNPC npc = (FactionNPC)f;
/*  69 */     if (npc.iteration() != this.fii)
/*  70 */       return null; 
/*  71 */     return npc;
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Party
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     public final int creditsP;
/*     */     public final int[] regsP;
/*     */     public int[] resP;
/*     */     
/*     */     Party(DealParty p) {
/*  84 */       this.creditsP = p.credits.get();
/*  85 */       this.regsP = Alloc.ii(p.regs.all().size()); int i;
/*  86 */       for (i = 0; i < this.regsP.length; i++) {
/*  87 */         this.regsP[i] = ((DealRegs.DealReg)p.regs.all().get(i)).is() ? ((DealRegs.DealReg)p.regs.all().get(i)).reg().index() : -1;
/*     */       }
/*  89 */       this.resP = Alloc.ii(TR.ALL().size());
/*  90 */       for (i = 0; i < this.resP.length; i++) {
/*  91 */         this.resP[i] = p.resources.get(TR.ALL().get(i));
/*     */       }
/*     */     }
/*     */     
/*     */     private Object readResolve() {
/*  96 */       int[] resP = Alloc.ii(TR.ALL().size());
/*  97 */       for (int i = 0; i < this.resP.length; i++) {
/*  98 */         TRADABLE res = (TRADABLE)TR.MAP().loader().get(i);
/*  99 */         if (res != null)
/* 100 */           resP[res.index()] = this.resP[i]; 
/*     */       } 
/* 102 */       this.resP = resP;
/* 103 */       return this;
/*     */     }
/*     */     
/*     */     CharSequence set(DealParty p) {
/* 107 */       p.credits.set(0);
/* 108 */       for (TRADABLE res : TR.ALL())
/* 109 */         p.resources.set(res, 0); 
/* 110 */       p.regs.clear();
/*     */ 
/*     */       
/* 113 */       if (this.creditsP > p.credits.max())
/* 114 */         return Dic.¤¤Curr; 
/* 115 */       p.credits.set(this.creditsP); byte b; int j, arrayOfInt[];
/* 116 */       for (j = (arrayOfInt = this.regsP).length, b = 0; b < j; ) { int k = arrayOfInt[b];
/* 117 */         if (k != -1) {
/* 118 */           Region reg = WORLD.REGIONS().getByIndex(k);
/* 119 */           if (!reg.active() || reg.faction() != p.f())
/* 120 */             return Dic.¤¤Region; 
/* 121 */           p.regs.add(reg);
/*     */         }  b++; }
/*     */       
/* 124 */       for (int i = 0; i < this.resP.length; i++) {
/* 125 */         if (this.resP[i] > 0 && this.resP[i] > p.resources.max(TR.ALL().get(i))) {
/* 126 */           return ((TRADABLE)TR.ALL().get(i)).names;
/*     */         }
/* 128 */         p.resources.set(TR.ALL().get(i), this.resP[i]);
/*     */       } 
/*     */       
/* 131 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealSave.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */