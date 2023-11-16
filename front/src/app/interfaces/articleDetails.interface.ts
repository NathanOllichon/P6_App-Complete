import { CommentArticle } from "./commentArticle.interface";

export interface ArticleDetails {
    titre: string,
    created_at: Date,
    auteur_name: string,
    contenu: string,
    id: number,
    theme_titre: string,
    commentaires: CommentArticle[]
}