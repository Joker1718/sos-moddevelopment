/*     */ package game.event.actions;
/*     */ 
/*     */ import game.event.engine.EContext;
/*     */ import game.event.engine.Event;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
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
/*     */ public final class Imp
/*     */   extends EventAction
/*     */ {
/*     */   private final Amount amount;
/*     */   private final boolean negativeAllowed;
/*     */   
/*     */   Imp(String key, Json data, LISTE<EventAction> all) {
/*  42 */     super(key, all);
/*  43 */     this.amount = new Amount(new EventAction.CInt(this, "AMOUNT"));
/*  44 */     this.amount.read(data, -2147483648);
/*  45 */     this.negativeAllowed = data.bool("NEGATIVE_ALLOWED", true);
/*  46 */     data.checkUnused();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setContext(Event event, EContext data) {
/*  51 */     this.amount.set(event, data, (int)FACTIONS.player().credits().credits());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void exe(Event event, EContext data) {
/*  58 */     FACTIONS.player().credits().inc(this.amount.amount.get(event, data), FCredits.CTYPE.MISC);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addToMessageBody(LISTE<RENDEROBJ> rows, final Event e, final EContext data, RECTANGLE messBody) {
/*  65 */     rows.add((new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  69 */             GFORMAT.i(text, _CREDITS.Imp.this.amount.amount.get(e, data));
/*     */           }
/*  71 */         }).hh((SPRITE)(UI.icons()).m.coins));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox b, Event event, EContext context) {
/*  77 */     b.add((SPRITE)(UI.icons()).s.money);
/*  78 */     b.textLL(Dic.¤¤Currs);
/*  79 */     b.tab(6);
/*  80 */     int ava = (int)FACTIONS.player().credits().credits();
/*     */     
/*  82 */     GText te = b.text();
/*  83 */     GFORMAT.i(te, this.amount.amount.get(event, context));
/*  84 */     b.add((SPRITE)te);
/*     */     
/*  86 */     te = b.text();
/*  87 */     te.add('(');
/*  88 */     GFORMAT.i(te, ava);
/*  89 */     te.add(')');
/*  90 */     te.normalify();
/*  91 */     b.add((SPRITE)te);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence problem(Event event, EContext context) {
/*  98 */     if (!this.negativeAllowed && -this.amount.amount.get(event, context) > FACTIONS.player().credits().getD())
/*  99 */       return _CREDITS.¤¤tooPoor; 
/* 100 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_CREDITS$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */