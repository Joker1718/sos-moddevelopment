/*     */ package game.faction.diplomacy.deal;
/*     */ 
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import java.io.Serializable;
/*     */ import snake2d.util.file.Alloc;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Party
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public final int creditsP;
/*     */   public final int[] regsP;
/*     */   public int[] resP;
/*     */   
/*     */   Party(DealParty p) {
/*  84 */     this.creditsP = p.credits.get();
/*  85 */     this.regsP = Alloc.ii(p.regs.all().size()); int i;
/*  86 */     for (i = 0; i < this.regsP.length; i++) {
/*  87 */       this.regsP[i] = ((DealRegs.DealReg)p.regs.all().get(i)).is() ? ((DealRegs.DealReg)p.regs.all().get(i)).reg().index() : -1;
/*     */     }
/*  89 */     this.resP = Alloc.ii(TR.ALL().size());
/*  90 */     for (i = 0; i < this.resP.length; i++) {
/*  91 */       this.resP[i] = p.resources.get(TR.ALL().get(i));
/*     */     }
/*     */   }
/*     */   
/*     */   private Object readResolve() {
/*  96 */     int[] resP = Alloc.ii(TR.ALL().size());
/*  97 */     for (int i = 0; i < this.resP.length; i++) {
/*  98 */       TRADABLE res = (TRADABLE)TR.MAP().loader().get(i);
/*  99 */       if (res != null)
/* 100 */         resP[res.index()] = this.resP[i]; 
/*     */     } 
/* 102 */     this.resP = resP;
/* 103 */     return this;
/*     */   }
/*     */   
/*     */   CharSequence set(DealParty p) {
/* 107 */     p.credits.set(0);
/* 108 */     for (TRADABLE res : TR.ALL())
/* 109 */       p.resources.set(res, 0); 
/* 110 */     p.regs.clear();
/*     */ 
/*     */     
/* 113 */     if (this.creditsP > p.credits.max())
/* 114 */       return Dic.¤¤Curr; 
/* 115 */     p.credits.set(this.creditsP); byte b; int j, arrayOfInt[];
/* 116 */     for (j = (arrayOfInt = this.regsP).length, b = 0; b < j; ) { int k = arrayOfInt[b];
/* 117 */       if (k != -1) {
/* 118 */         Region reg = WORLD.REGIONS().getByIndex(k);
/* 119 */         if (!reg.active() || reg.faction() != p.f())
/* 120 */           return Dic.¤¤Region; 
/* 121 */         p.regs.add(reg);
/*     */       }  b++; }
/*     */     
/* 124 */     for (int i = 0; i < this.resP.length; i++) {
/* 125 */       if (this.resP[i] > 0 && this.resP[i] > p.resources.max(TR.ALL().get(i))) {
/* 126 */         return ((TRADABLE)TR.ALL().get(i)).names;
/*     */       }
/* 128 */       p.resources.set(TR.ALL().get(i), this.resP[i]);
/*     */     } 
/*     */     
/* 131 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealSave$Party.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */