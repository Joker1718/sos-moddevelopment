/*     */ package game.faction.royalty.opinion;
/*     */ 
/*     */ import game.faction.royalty.Royalty;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import view.ui.message.MessageSection;
/*     */ import view.world.ui.faction.UIRoyalty;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Mess
/*     */   extends MessageSection
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String desc;
/*     */   private final Induvidual indu;
/*     */   private final String name;
/*     */   private final String fName;
/*     */   private int sI;
/*     */   
/*     */   public Mess(CharSequence title, CharSequence desc, Royalty roy) {
/* 199 */     super(title);
/* 200 */     this.desc = String.valueOf(desc);
/* 201 */     this.name = String.valueOf(roy.name());
/* 202 */     this.indu = roy.induvidual;
/* 203 */     this.sI = roy.successionI();
/* 204 */     this.fName = String.valueOf(roy.court.faction.name);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/* 209 */     paragraph((CharSequence)Str.TMP.clear().add(this.desc).insert("NAME", this.name).insert("FACTION", this.fName).insert("HIS", (this.indu.race()).info.pHIS.get(this.indu, false)));
/* 210 */     section.addRelBody(8, DIR.N, (SPRITE)new UIRoyalty.PortraitAbs(4)
/*     */         {
/*     */           protected int succ()
/*     */           {
/* 214 */             return OpsEmi.Mess.this.sI;
/*     */           }
/*     */ 
/*     */           
/*     */           protected Induvidual indu() {
/* 219 */             return OpsEmi.Mess.this.indu;
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\OpsEmi$Mess.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */